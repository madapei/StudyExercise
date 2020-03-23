package com.mapei.javatest.test20181226;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/26
 */
@Component
public class OnlineDataSource implements DataSource{

//    private DbType dbType;
//    @Autowired
//    public OnlineDataSource(DbType dbType) {
//        this.dbType = dbType;
//    }

    public void start(){

//        System.out.println("OnlineDataSource=" + dbType.getDbType() + ":" + dbType.hashCode() + " start!");
        System.out.println("OnlineDataSource start");
    }
}
