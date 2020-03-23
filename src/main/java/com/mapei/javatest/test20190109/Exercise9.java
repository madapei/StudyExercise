package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
interface ExerciseInterface9{
    void print(String param);
}

public class Exercise9 {
    private String name = "mapei";

    public ExerciseInterface9 getInterface(){
        class ExerciseInner9 implements ExerciseInterface9{
            @Override
            public void print(String param) {
                System.out.println(param);
            }
        }
        return new ExerciseInner9();
    }

    public ExerciseInterface9 innerPrint(){
        if (name.equals("dapei")){
            class Inner9 implements ExerciseInterface9{
                @Override
                public void print(String param) {
                    System.out.println(param);
                }
            }
            return new Inner9();
        }
        return null;
    }

    public void print(){
        getInterface().print(name);
    }

    public static void main(String[] args) {
        Exercise9 e = new Exercise9();
        e.print();
        ExerciseInterface9 interface9 = e.innerPrint();
        if (interface9 == null){
            e.name = "dapei";
            interface9 = e.innerPrint();
            interface9.print("haha");
        }
        else{
            interface9.print("123");
        }

    }
}
