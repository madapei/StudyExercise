package com.mapei.javatest.test20190114;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */
public class Pet {
        private String name;

        public Pet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public static List arrayList(){
            List<Pet> pets = new ArrayList<>();
            pets.add(new Pet("dahua"));
            pets.add(new Pet("mmi"));
            pets.add(new Pet("miaomiao"));
            pets.add(new Pet("dabai"));
            pets.add(new Pet("maomao"));
            pets.add(new Pet("xiaomi"));
            return pets;
        }
}
