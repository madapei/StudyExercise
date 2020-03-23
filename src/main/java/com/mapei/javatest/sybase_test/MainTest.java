package com.mapei.javatest.sybase_test;

import com.mapei.javatest.dbtest.CharacterType;
import com.mapei.javatest.dbtest.OraclePreparedStatementProxy;
import com.mapei.javatest.dbtest.OracleTest;
import org.aspectj.apache.bcel.classfile.Modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/29
 */
public class MainTest{
    private int i = 10;
    private OracleTest oracle = new OracleTest();

    public static void main(String[] args) {
//        MainTest t = new MainTest();
//        try {
//            MainTest newT = t.clone();
//            System.out.println("newT.i=" + newT.i);
//            System.out.println("newT.date=" + newT.oracle.hashCode());
//            System.out.println("t.date=" + t.oracle.hashCode());
//        } catch (CloneNotSupportedException e) {
//            System.out.println("CloneNotSupportedException");
//        } catch (Exception e){
//            System.out.println("Exception");
//        }
        try {
            Class classObj = Class.forName("com.mapei.javatest.sybase_test.ClassTest");
            //实例化带参构造器的类对象
            ClassTest test = (ClassTest) classObj.getConstructor(String.class).newInstance("Hello");

            Field field = classObj.getDeclaredField("age");
            field.setAccessible(true);
            Object o = field.get(test);
            System.out.println(o);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        catch (NoSuchMethodException e){
//            e.printStackTrace();
//        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected MainTest clone() throws CloneNotSupportedException {
        MainTest test = (MainTest) super.clone();
        test.oracle = new OracleTest();
        return test;
    }
}
