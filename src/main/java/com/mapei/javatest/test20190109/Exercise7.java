package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class Exercise7 {
    private String name;
    private void print(){
        System.out.println(name);
    }

    public class Inner7{
        private int id = 2;

        public void inner(){
            name = "inner";
            print();
        }
    }

    public Inner7 getInner(){
        return new Inner7();
    }

    public static void main(String[] args) {
        Exercise7 exercise7 = new Exercise7();
        exercise7.name = "outer";
        exercise7.print();

        Inner7 inner7 = exercise7.getInner();
        System.out.println(inner7.id);
        inner7.inner();
    }
}
