package com.mapei.javatest.test_generics;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/12
 */
public class Manager extends Employee{
    private int bonus;

    @Override
    public String toString(){
        return "Manager";
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
