package com.mapei.javatest.test_stream;

import java.io.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/25
 */
public class SerialCtl implements Serializable{
    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        System.out.println("Start Constructor:");
        this.a = "Not Transient: " + a;
        this.b = "Transient: " + b;
    }

    public String toString(){
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException{
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) {
        try {
            SerialCtl sc = new SerialCtl("Test1", "Test2");
            System.out.println("Before:\n" + sc);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(buf);
            o.writeObject(sc);
            System.out.println();

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            SerialCtl sc2 = (SerialCtl)in.readObject();
            System.out.println("After:\n" + sc2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
