package com.sany.回溯.子集与组合;

import java.util.*;

/**
 * leetcode77经典数学题：求排列组合里面的组合 C42 即4个里面选出两个来。
 * leetcode78
 */
public class _0077 {

    /**
     * leetcode.77题
     */
    private int n;
    private int k;
    private List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        backTrack(1, n - k + 1, deque);
        return result;
    }

    private void backTrack(int begin, int end, Deque<Integer> deque) {
        if (deque.size() == k) {
            result.add(new ArrayList<>(deque));
            return;
        }
        //int nextEnd = n - k + deque.size() + 1;
        for (int i = begin; begin <= end; i++) {
            deque.addLast(i);
            backTrack(i + 1, end + 1, deque);
            deque.pollLast();
        }
    }
}
