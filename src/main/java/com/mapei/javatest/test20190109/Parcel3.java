package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/9
 */
public class Parcel3 {
    class Contents{
        private int i = 11;
        public int value(){
        return i;
    }
    }

    static class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Contents c = parcel3.new Contents();
        Destination d = new Destination("Tasmania");
    }
}
