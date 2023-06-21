package com.sany.回溯.字符串回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 字母的大小写全排列
 */
public class _0784 {

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<List<Character>> list = new ArrayList<>();
        Deque<Character> deque = new ArrayDeque<>();
        backTrack(0, chars, deque, list);

        List<String> result = new ArrayList<>(list.size());
        for (List<Character> subList : list) {
            StringBuilder sb = new StringBuilder();
            subList.forEach(v -> sb.append(v));
            result.add(sb.toString());
        }
        return result;
    }

    private void backTrack(int index, char[] chars, Deque<Character> deque, List<List<Character>> list) {
        if (index == chars.length) {
            list.add(new ArrayList<>(deque));
            return;
        }
        Character character = chars[index];
        if (character >= '0' && character <= '9') {
            deque.addLast(character);
            backTrack(index + 1, chars, deque, list);
            deque.pollLast();
            return;
        }
        deque.addLast(Character.toLowerCase(character));
        backTrack(index + 1, chars, deque, list);
        deque.pollLast();
        deque.addLast(Character.toUpperCase(character));
        backTrack(index + 1, chars, deque, list);
        deque.pollLast();
    }
}
