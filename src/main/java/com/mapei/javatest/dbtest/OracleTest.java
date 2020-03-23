package com.mapei.javatest.dbtest;

import com.mapei.javatest.test20181226.Oracle;
import oracle.sql.CharacterSet;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Comparator;
import java.util.Locale;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/19
 */
public class OracleTest {
    private Connection conn = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        OracleTest test = new OracleTest();
        test.getConnection();
        test.insert();
    }

    public String getConnection(){

        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            String url="jdbc:oracle:thin:@192.168.211.161:1521:orcl";
            String username = "oracle";
            String password = "123qweASD";
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public void insert(){
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            stmt.addBatch("insert into TEST(COL) VALUES (" + "12345" + ")");
            stmt.addBatch("insert into TEST(COL) VALUES (" + "12345" + ")");
            stmt.addBatch("insert into TEST(COL) VALUES (" + "12345" + ")");
            stmt.addBatch("insert into TEST(COL) VALUES (" + "123456" + ")");
            stmt.addBatch("insert into TEST(COL) VALUES (" + "12345" + ")");
            stmt.executeBatch();
            conn.commit();

        }catch (BatchUpdateException e) {
            try {
                int[] arr = e.getUpdateCounts();
                conn.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


