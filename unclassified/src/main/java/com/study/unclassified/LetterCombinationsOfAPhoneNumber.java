package com.study.unclassified;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        char[] charArray = digits.toCharArray();
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(charArray[i]);
            String digitChars = getDigitChars(num);
            list = combina(list, digitChars);
        }
        return list;
    }

    private String getDigitChars(int digit) {
        String[] charsArr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return charsArr[digit];
    }

    private List<String> combina(List<String> list, String str) {
        if (list.size() == 0) {
            for (int i = 0; i < str.length(); i++) {
                list.add(str.substring(i, i + 1));
            }
        } else {
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                String ch = str.substring(i, i + 1);
                for (int j = 0; j < list.size(); j++) {
                    newList.add(list.get(j).concat(ch));
                }
            }
            list = newList;
        }
        return list;
    }

}
