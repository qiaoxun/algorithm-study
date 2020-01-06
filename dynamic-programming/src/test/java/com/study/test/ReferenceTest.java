package com.study.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReferenceTest {

    @Test
    public void test() {
        Map<String, String> map = new HashMap();
        map.put("s", "s");
        changeMap(map);
        System.out.println(map);
    }

    public void changeMap(Map<String, String> map) {
        map = null;
    }

}
