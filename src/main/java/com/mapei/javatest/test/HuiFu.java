package com.mapei.javatest.test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/23
 */
public class HuiFu {
    public static void main(String[] args) {
//        System.out.println("2323wsedds!@##@qq.com".matches("^([A-Za-z]{1}[\\w|\\W]*[A-Za-z]{1}@huifu.com)|([\\w|\\W]+@qq.com)$"));

        while(true){
            Scanner scanner = new Scanner(System.in);
            boolean b = scanner.nextLine().matches("([A-Za-z0-9._%+-]+@([A-Za-z0-9.-]+)\\.([A-Za-z]{2,4}))((?![A-Za-z\\*]\\*+[A-Za-z\\*]@[\\w\\W]+.[\\w\\W]+).*)");
            System.out.println(b);
//            Pattern p = Pattern.compile("([A-Za-z0-9._%+-]+@([A-Za-z0-9.-]+)\\.([A-Za-z]{2,4}))((?![A-Za-z\\*]\\*+[A-Za-z\\*]@[\\w\\W]+.[\\w\\W]+).*)");
//            System.out.println(p.matcher(scanner.nextLine()).matches());
        }
    }
}
