package com.mapei.javatest.test_stream;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/25
 */
public class Logon implements Serializable{
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try {
            Logon a = new Logon("Hulk", "myLittlePony");
            System.out.println("logon a=" + a);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("F:\\test_file\\Logon.out"));
            o.writeObject(a);
            o.close();
            TimeUnit.SECONDS.sleep(1);
            System.out.println();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\test_file\\Logon.out"));
            System.out.println("Recovering object at " + new Date());
            a = (Logon)in.readObject();
            System.out.println("Logon a = " + a);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
