package com.sany.回溯.子集与组合;

import java.util.*;

/**
 * 给定一个数组，选出数组的组合，使其和等于给定的目标值
 * 给定的数组可能有相等的值，数组元素不能重复使用
 */
public class _0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> deque = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, target, deque, resultList);
        return resultList;
    }

    private void backTrack(int begin, int[] candidates, int target, Deque<Integer> deque, List<List<Integer>> resultList) {
        if (target == 0) {
            resultList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            deque.add(candidates[i]);
            backTrack(i + 1, candidates, target - candidates[i], deque, resultList);
            deque.pollLast();
        }
    }
}
