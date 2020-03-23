package com.mapei.javatest.test_stream;

import sun.util.resources.LocaleData;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/24
 */
public class SerialTest {
    public static void main(String[] args) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SerialClass obj = new SerialClass(29, "mapei", format.parse("1990-04-28"));
            FileOutputStream fout = new FileOutputStream("F:\\test_file\\serial_file.txt");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeUTF("This is an Serial Object.\r\n");
            oout.writeObject(obj);
            oout.flush();
            oout.close();

            FileInputStream fin = new FileInputStream("F:\\test_file\\serial_file.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);
            System.out.println(oin.readLine());
            SerialClass o = (SerialClass) oin.readObject();
            System.out.println(o);

        }
        catch (ParseException e){
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
