package com.mapei.javatest.dbtest;

import oracle.jdbc.OraclePreparedStatement;
import oracle.sql.CharacterSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/20
 */
public class OraclePreparedStatementProxy implements InvocationHandler{
    private static final Log logger = LogFactory.getLog(OraclePreparedStatementProxy.class);

    private PreparedStatement target;

    private CharacterType characterType;

    private Object clientCharSetIdTmp;

    private Object clientCharSetTmp;

    private Object conversionField;



    public OraclePreparedStatementProxy(PreparedStatement target, CharacterType characterType) {
        this.target = target;
        this.characterType = characterType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().equals("executeQuery")||method.getName().equals("executeUpdate")||method.getName().equals("close")) {
                if (target instanceof OraclePreparedStatement){
                    if (method.getName().equals("close")){//上下文依赖 清除设置
                        filterStatementCharacterSet(target,characterType,Boolean.FALSE);
                    }else {
                        filterStatementCharacterSet(target,characterType,Boolean.TRUE);
                    }
                    return method.invoke(target, args);

                }
            }
            return method.invoke(target, args);
        } catch (Exception e) {
            if (e.getCause() == null) {
                throw e;
            } else {
                throw e.getCause();
            }
        }
    }


    /**
     * 由于oracle驱动无法直接设置编码 且底层使用getBytes()将数据流传给db，严重依赖运行环境的编码
     * 在这里指定客户端编码来解决
     * @param oraclePreparedStatement
     */
    private void filterStatementCharacterSet(Object oraclePreparedStatement, CharacterType characterType,boolean isGet){
        try {
            if (null==characterType||characterType==CharacterType.UNKNOWN){
                return;
            }
            CharacterSet characterSet;
            switch (characterType){
                case UTF8:
                case UTF_8:
                    characterSet=CharacterSet.make(CharacterSet.UTF8_CHARSET);
                    break;
                case GB2312:
                case ISO8859_1:
                case ISO_8859_1:
                case GBK:
                    characterSet=CharacterSet.make(CharacterSet.ZHS16GBK_CHARSET);
                    break;
                default:
                    return;
            }
            Class<?> c;
            if (isGet){
                c = Class.forName("oracle.jdbc.driver.OraclePreparedStatementWrapper");
                Field preparedStatement = c.getDeclaredField("preparedStatement");
                preparedStatement.setAccessible(true);
                Object t4CPreparedStatement = preparedStatement.get(oraclePreparedStatement);

                c = Class.forName("oracle.jdbc.driver.OracleStatement");
                Field sqlObject = c.getDeclaredField("sqlObject");
                sqlObject.setAccessible(true);
                Object sqlObjectField = sqlObject.get(t4CPreparedStatement);

                c = Class.forName("oracle.jdbc.driver.OracleSql");
                Field conversion = c.getDeclaredField("conversion");
                conversion.setAccessible(true);
                conversionField = conversion.get(sqlObjectField);
            }
            c = Class.forName("oracle.jdbc.driver.DBConversion");
            Field clientCharSetId = c.getDeclaredField("clientCharSetId");
            clientCharSetId.setAccessible(true);

            if (isGet){
                //设置开启客户端编码
                clientCharSetIdTmp=clientCharSetId.get(conversionField);
                clientCharSetId.setShort(conversionField, (short) 2);
            }else {
                clientCharSetId.set(conversionField, clientCharSetIdTmp);
            }

            Field clientCharSet = c.getDeclaredField("clientCharSet");
            clientCharSet.setAccessible(true);
            if (isGet){
                //设置客户端编码
                clientCharSetTmp=clientCharSet.get(conversionField);
                clientCharSet.set(conversionField, characterSet);
            }else {
                clientCharSet.set(conversionField, clientCharSetTmp);
            }
        } catch (Exception e) {
            logger.error("filterStatementCharacterSet error!",e);
        }

    }
}
