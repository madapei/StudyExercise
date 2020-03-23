package com.mapei.javatest.test20181226;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/26
 */
@Component
public class DevDataSource implements DataSource{

    private DbType dbType;


//    public DevDataSource(DbType dbType) {
//        this.dbType = dbType;
//    }


    public void start(){
        System.out.println("DevDataSource start! and dbType is" + dbType.getDbType());
    }

    @Autowired
//    @Qualifier("one")
    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }
}
