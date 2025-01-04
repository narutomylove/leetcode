package com.sany.回溯.子集与组合;

import java.util.*;

/**
 * 给定一个数组，选出数组的组合，使其和等于给定的目标值
 * 数组元素没有相等的数字，数组元素可以重复使用
 */
public class _0039 {

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
}
