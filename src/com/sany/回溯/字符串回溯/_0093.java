package com.sany.回溯.字符串回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原IP地址
 */
public class _0093 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();
        backTrack(chars, 0, 0, list, resultList);
        resultList.forEach(v -> result.add(String.join(".", v)));
        return result;
    }

    private void backTrack(char[] chars, int begin, int len, List<String> list, List<List<String>> result) {
        int remain = chars.length - begin;
        if (remain < 4 - len || remain > 12 - 3 * len) {
            return;
        }
        if (len == 4 && begin == chars.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 取1个数
        list.add(String.valueOf(chars[begin]));
        backTrack(chars, begin + 1, len + 1, list, result);
        list.remove(list.size() - 1);
        // 取2个数
        if (chars[begin] == '0' || remain < 2) {
            return;
        }
        list.add(chars[begin] + String.valueOf(chars[begin + 1]));
        backTrack(chars, begin + 2, len + 1, list, result);
        list.remove(list.size() - 1);
        // 取3个数
        if (remain < 3) {
            return;
        }
        String num3 = chars[begin] +
                String.valueOf(chars[begin + 1]) + chars[begin + 2];
        if (Integer.valueOf(num3) > 255) {
            return;
        }
        list.add(num3);
        backTrack(chars, begin + 3, len + 1, list, result);
        list.remove(list.size() - 1);
    }

    /**
     * 2刷此题写出的结果
     */
    public List<String> restoreIpAddresses1(String s) {
        List<String> resultList = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return resultList;
        }
        Deque<String> deque = new LinkedList<>();
        backTrack1(s, deque, resultList);
        return resultList;
    }

    private void backTrack1(String s, Deque<String> deque, List<String> resultList) {
        if (deque.size() == 4) {
            if (s.length() < 1) {
                resultList.add(deque.stream().collect(Collectors.joining(".")));
            }
            return;
        }
        if (s.length() == 0) {
            return;
        }
        int end = 4;
        int firstNum = Character.getNumericValue(s.charAt(0));
        if (firstNum == 0) {
            end = 2;
        }
        for (int i = 1; i < end; i++) {
            if (s.length() < i) {
                continue;
            }
            String subString = s.substring(0, i);
            if (Integer.valueOf(subString) > 255) {
                continue;
            }
            deque.add(subString);
            String leftString = s.substring(i, s.length());
            backTrack1(leftString, deque, resultList);
            deque.pollLast();
        }
    }
}
