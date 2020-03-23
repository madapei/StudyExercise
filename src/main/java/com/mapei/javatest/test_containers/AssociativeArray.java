package com.mapei.javatest.test_containers;

import java.util.Properties;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/19
 */
public class AssociativeArray<K, V>{
    private Object[][] paris;
    private int index;
    public AssociativeArray(int length){
        paris = new Object[length][2];
    }
    public void put(K key, V value){
        if (index >= paris.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        paris[index++] = new Object[]{key, value};
    }

    public V get(K key){
        for (int i = 0; i < index; i++){
            if (key.equals(paris[i][0])){
                return (V)paris[i][1];
            }
        }
        return null;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++){
            result.append(paris[i][0].toString());
            result.append(" : ");
            result.append(paris[i][1].toString());
            if (i < index - 1){
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (Exception e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
