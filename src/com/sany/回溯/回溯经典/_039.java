package com.sany.回溯.回溯经典;

import java.util.*;

/**
 * leetcode.39 & 40 合到一起看
 */
public class _039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        backTrack(candidates, 0, deque, resultList, target);
        return resultList;
    }

    private void backTrack(int[] candidates, int begin, Deque<Integer> deque, List<List<Integer>> resultList, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            resultList.add(new ArrayList<>(deque));
        }
        for (int i = begin; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            backTrack(candidates, i, deque, resultList, target - candidates[i]);
            deque.pollLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        //boolean[] pickFlag = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTrack2(candidates, 0, deque, resultList, target);
        return resultList;
    }

    private void backTrack2(int[] candidates, int begin, Deque<Integer> deque, List<List<Integer>> resultList, int target) {
        if (target == 0) {
            resultList.add(new ArrayList<>(deque));
        }
        if (target < 0) {
            return;
        }
        if (begin > 0 && begin < candidates.length && candidates[begin] == candidates[begin - 1]) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            deque.addLast(candidates[i]);
            backTrack2(candidates, i + 1, deque, resultList, target - candidates[i]);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        _039 object = new _039();
        object.combinationSum2(candidates, 8);
    }
}
