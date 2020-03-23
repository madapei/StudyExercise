package com.mapei.javatest.test_typeInformation;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/12
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof, Shoots {
    FancyToy(){
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:" + cc.getName() + "; is interface?[" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.mapei.javatest.test_typeInformation.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
        }
        System.out.println("_________________________");
        printInfo(obj.getClass());
    }
}
