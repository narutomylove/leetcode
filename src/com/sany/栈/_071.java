package com.sany.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化UNIX风格路径
 */
public class _071 {

    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] subPath = path.split("/");
        for (String pathItem : subPath) {
            if (pathItem.length() == 0 || pathItem.equals(".")) {
                continue;
            }
            if (pathItem.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            deque.offer(pathItem);
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String realPath : deque) {
            sb.append("/").append(realPath);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(2);
        System.out.println(stack.peek());
        stack.pollLast();
        System.out.println(11);
    }
}
