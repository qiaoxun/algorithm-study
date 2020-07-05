package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tester {

    @Test
    public void arrayListDeleteInLoop() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        int size = list.size();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.size());
//            String s = list.get(i);
//            System.out.println(s);
//            if (s.equals("13") || s.equals("12")) {
//                list.remove(i);
//            }
//        }

//        for (String s : list) {
//            if (s.equals("13") || s.equals("12")) {
//                list.remove(s);
//            }
//        }

        for (int i = 0, len = list.size(); i < len; i++) {

        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("13") || next.equals("12")) {
                iterator.remove();
            }
            System.out.println(next);
        }


        System.out.println(list);


    }

}
