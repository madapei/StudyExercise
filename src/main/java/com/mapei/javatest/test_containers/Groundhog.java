package com.mapei.javatest.test_containers;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/22
 */
public class Groundhog {
    protected int number;
    public Groundhog(int n){
        number = n;
    }
    public String toString(){
        return "Groundhog #" + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Groundhog)) return false;

        Groundhog groundhog = (Groundhog) o;

        return number == groundhog.number;

    }

    @Override
    public int hashCode() {
        return number;
    }
}
