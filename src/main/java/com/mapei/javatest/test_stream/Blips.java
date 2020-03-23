package com.mapei.javatest.test_stream;

import java.io.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/25
 */
class Blip1 implements Externalizable{
    public Blip1(){
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}
class Blip2 implements Externalizable{
    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}
class Blip3 implements Externalizable{
    private int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }

    public Blip3(int i, String s) {
        System.out.println("Blip3(int a, String s)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String)in.readObject();
        i = in.readInt();
    }
}
public class Blips {
    public static void main(String[] args) {
        try {
            System.out.println("Constructing objects:");
            Blip1 b1 = new Blip1();
            Blip2 b2 = new Blip2();
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("F:\\test_file\\Blips.out"));
            System.out.println("Saving objects:");
            o.writeObject(b1);
            o.writeObject(b2);
            o.close();
            System.out.println();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\test_file\\Blips.out"));
            System.out.println("Recovering b1:");
            b1 = (Blip1) in.readObject();
            System.out.println("Recover b2:");
            b2 = (Blip2)in.readObject();
            in.close();
            System.out.println();

            System.out.println("Constructing objects:");
            Blip3 b3 = new Blip3(47,"A String ");
            System.out.println(b3);
            ObjectOutputStream o3 = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
            System.out.println("Saving object:");
            o3.writeObject(b3);
            o3.close();
            ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("Blip3.out"));
            System.out.println("Recovering b3:");
            b3 = (Blip3)in3.readObject();
            System.out.println(b3);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
