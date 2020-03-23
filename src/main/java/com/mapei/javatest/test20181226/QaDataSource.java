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
public class QaDataSource implements DataSource{
    /*private MySql mySql;

    @Autowired
    public QaDataSource(MySql mySql) {
        this.mySql = mySql;
    }*/

    public void start(){
        System.out.println("QA datasource start!");
    }
}
