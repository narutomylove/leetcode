package com.sany.栈;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 开始“栈”的第一天
 * 1. 效的括号
 * 2. 进阶版，最长有效括号
 */
public class _020 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        Map<Character, Character> upsideCharMap = new HashMap<>();
        upsideCharMap.put('(', ')');
        upsideCharMap.put('{', '}');
        upsideCharMap.put('[', ']');
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            if (upsideCharMap.containsKey(chars[i])) {
                list.add(chars[i]);
                continue;
            }
            if (!charMap.containsKey(chars[i])) {
                return false;
            }
            if (list.isEmpty()) {
                return false;
            }
            if (list.pollLast() != charMap.get(chars[i])) {
                return false;
            }
        }
        return list.isEmpty();
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                list.add(i);
                continue;
            }
            int lastNum = list.pollLast();
            if (list.isEmpty()) {
                list.add(i);
                continue;
            }
            maxLen = Math.max(maxLen, i - list.get(list.size() - 1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
