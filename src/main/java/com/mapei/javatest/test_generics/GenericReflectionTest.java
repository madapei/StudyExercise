package com.mapei.javatest.test_generics;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;


public class GenericReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0){
            name = args[0];
        }
        else {
            try (Scanner in = new Scanner(System.in)){
                System.out.println("Enter class name:");
                name = in.next();
            }
        }

        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for (Method m : cl.getDeclaredMethods()){
                printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl){
        System.out.print(cl);
        //cl.getTypeParameters():返回一个TypeVariable对象的数组，它们以声明顺序表示由此GenericDeclaration对象表示的通用声明声明的类型变量。
        // 如果底层通用声明不声明类型变量，则返回长度为0的数组。
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null){
            System.out.print(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method m){
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", "> ", true);
        printType(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(), "", ", ","", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition){
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
            return;
        if (types.length > 0)
            System.out.print(pre);
        for(int i = 0; i < types.length; i++){
            if (i > 0) System.out.print(sep);
                printType(types[i], isDefinition);
        }
        if (types.length > 0)
            System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition){
        if (type instanceof  Class){
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        else if (type instanceof TypeVariable){
            TypeVariable<?> t = (TypeVariable<?>)type;
            System.out.print(t.getName());
            if (isDefinition){
                //getBounds():返回表示此类型变量的上限的 Type对象的数组。
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        }
        //WildcardType表示一个通配符型表达，如 ? ， ? extends Number ，或 ? super Integer
        else if (type instanceof WildcardType){
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        }
        //ParameterizedType表示一个参数化类型，如Collection <String>
        else if (type instanceof ParameterizedType){
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null){
                printType(owner, false);
                System.out.print(".");
            }
            //返回表示声明此类型的类或接口的 Type对象
            printType(t.getRawType(),false);
            //返回一个表示此类型的实际类型参数的数组 Type对象
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        }
        //GenericArrayType表示组件类型是参数化类型或类型变量的数组类型
        else if (type instanceof GenericArrayType){
            GenericArrayType t = (GenericArrayType)type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}
