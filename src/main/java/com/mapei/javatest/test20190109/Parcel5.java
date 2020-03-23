package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination (String whereTo){
                label = whereTo;
            }

            @Override
            public String readLable() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLable());
    }
}
