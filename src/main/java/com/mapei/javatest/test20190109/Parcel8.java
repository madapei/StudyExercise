package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class Parcel8 {

    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int value(){
                return super.value() * 2;
            }
        };
    }

    public Destination destination(String dest){
        return new Destination() {
            private String label = dest;
            @Override
            public String readLable() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
        Destination d = p.destination("hello");
        System.out.println(d.readLable());
    }
}
