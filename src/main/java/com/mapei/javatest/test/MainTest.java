package com.mapei.javatest.test;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/11
 */
public class MainTest {
    public static void main(String[] args) {
        String[] array = "For a static method reference, as illustrated in the previous section".split(" ");
        Arrays.sort(array, MpString::compareLong);
        System.out.println("compareLong: " + Arrays.toString(array));

        Arrays.sort(array, MpString::compareShort);
        System.out.println("compareShort: " + Arrays.toString(array));

    }


}
class MpString{
    static int compareLong(String a, String b){
        if (a.length() > b.length()){
            return 1;
        }
        else if (a.length() == b.length()){
            return 0;
        }
        else {
            return -1;
        }
    }

    static int compareShort(String a, String b){
        if (a.length() < b.length()){
            return 1;
        }
        else if (a.length() == b.length()){
            return 0;
        }
        else {
            return -1;
        }
    }
}
