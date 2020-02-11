package com.chen.p;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {
        // initialise list
        IntLinkedList list1 = new IntLinkedList();

        System.out.println("add(value) test:");
        for (int i = 0; i < 10; i++) {
//            list1.add(RANDOM.nextInt(10));
            list1.add(i);
        }
        inspect(list1);
        System.out.println("get(index) test:");
        for (int i = 0; i < 10; i++) {
            System.out.print(" ");
            System.out.print(list1.get(i) + " ");
        }
        System.out.println("");
        System.out.println("size() test:");
        System.out.print (" size is: "+list1.size());
        System.out.println("add(value, index) test:");
        list1.add(0, 111);
        int tmp = RANDOM.nextInt(list1.size() - 2) + 1;
        list1.add(tmp, tmp * 111);
        list1.add(list1.size(), 999);
        inspect(list1);
        System.out.println("remove(index) test");
        list1.remove(tmp);
        list1.remove(0);
        list1.remove(list1.size());
        inspect(list1);

    }

    public static void inspect(IntLinkedList list) {
        System.out.println(list.toString());
    }

}
