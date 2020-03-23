package com.mapei.javatest.test_containers;

import edu.emory.mathcs.backport.java.util.*;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.LinkedList;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/18
 */
public class MainTest{
    public static void main(String[] args) {
        DataInputStream in = new DataInputStream(System.in);
        try {
            System.out.println(in.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
