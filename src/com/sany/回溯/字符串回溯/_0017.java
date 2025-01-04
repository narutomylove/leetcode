package com.sany.回溯.字符串回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0017 {

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return resultList;
        }
        Map<Integer, char[]> numMap = new HashMap<>();
        numMap.put(2, new char[]{'a', 'b', 'c'});
        numMap.put(3, new char[]{'d', 'e', 'f'});
        numMap.put(4, new char[]{'g', 'h', 'i'});
        numMap.put(5, new char[]{'j', 'k', 'l'});
        numMap.put(6, new char[]{'m', 'n', 'o'});
        numMap.put(7, new char[]{'p', 'q', 'r', 's'});
        numMap.put(8, new char[]{'t', 'u', 'v'});
        numMap.put(9, new char[]{'w', 'x', 'y', 'z'});
        StringBuilder sb = new StringBuilder();
        backTrack(0, digits, numMap, sb, resultList);
        return resultList;
    }

    public void backTrack(int index, String digits, Map<Integer, char[]> numMap, StringBuilder sb, List<String> resultList) {
        if (sb.length() == digits.length()) {
            resultList.add(sb.toString());
            return;
        }
        char[] chars = numMap.get(Character.getNumericValue(digits.charAt(index)));
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            backTrack(index + 1, digits, numMap, sb, resultList);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
