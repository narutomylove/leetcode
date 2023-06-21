package com.sany.回溯.字符串回溯;

import java.util.*;

public class _022 {

    private final Character LEFT = Character.valueOf('(');
    private final Character RIGHT = Character.valueOf(')');
    public List<String> generateParenthesis(int n) {
        List<List<Character>> list = new ArrayList<>();
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> supDeque = new ArrayDeque<>();
        backTrack(n, n, deque, supDeque, list);

        List<String> result = new ArrayList<>(list.size());
        for (List<Character> subList : list) {
            StringBuilder sb = new StringBuilder();
            subList.forEach(v -> sb.append(v));
            result.add(sb.toString());
        }
        return result;
    }

    private void backTrack(int leftNum, int rightNum, Deque<Character> deque, Deque<Character> supDeque, List<List<Character>> list) {
        if (leftNum == 0 && rightNum == 0) {
            list.add(new ArrayList<>(deque));
            return;
        }
        // 选左括号 '('
        if (leftNum > 0) {
            supDeque.addLast(LEFT);
            deque.addLast(LEFT);
            backTrack(leftNum - 1, rightNum, deque, supDeque, list);
            supDeque.pollLast();
            deque.pollLast();
        }
        // 选右括号 ')'
        if (rightNum > 0 && !supDeque.isEmpty() && supDeque.peekLast().equals(LEFT)) {
            deque.addLast(RIGHT);
            supDeque.pollLast();
            backTrack(leftNum, rightNum - 1, deque, supDeque, list);
            supDeque.addLast(LEFT);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        _022 object = new _022();
        object.generateParenthesis(3);
    }
}
