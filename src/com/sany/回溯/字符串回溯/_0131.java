package com.sany.回溯.字符串回溯;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串
 * (第一次做 完全不会)
 * 关键还是画出递归树
 */
public class _0131 {

    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        backTrack(s, deque, resultList);
        return resultList;
    }

    private void backTrack(String s, Deque<String> deque, List<List<String>> resultList) {
        if (s.length() < 1) {
            resultList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if (!judge(subString)) {
                continue;
            }
            deque.add(subString);
            String leftString = s.substring(i, s.length());
            backTrack(leftString, deque, resultList);
            deque.pollLast();
        }
    }

    /**
     * 判断字符串是否回文串
     */
    private boolean judge(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _0131 object = new _0131();
    }

}
