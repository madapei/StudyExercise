package com.mapei.javatest.test_enum;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/4
 */
enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString(){
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++){
            System.out.println(t);
            t.change();
        }
    }
}
