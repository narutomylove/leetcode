package com.sany.回溯.回溯经典;

import java.util.*;

/**
 * leetcode77经典数学题：求排列组合里面的组合 C42 即4个里面选出两个来。
 * leetcode78
 */
public class _077 {

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

    /**
     * leetcode.78题
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(subList);
        backTrack(0, nums, subList, result);
        return result;
    }

    private void backTrack(int begin, int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        for (int i = begin; i < nums.length; i++) {
            List<Integer> tmpList = new ArrayList<>(list);
            tmpList.add(nums[i]);
            resultList.add(tmpList);
            backTrack(i + 1, nums, tmpList, resultList);
        }
    }

    /**
     * leetcode.90题(78题进阶版本)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        backTrack1(0, nums, list, result);
        return result;
    }

    private void backTrack1(int begin, int[] nums, List<Integer> list, List<List<Integer>> result) {
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> tmpList = new ArrayList<>(list);
            tmpList.add(nums[i]);
            result.add(tmpList);
            backTrack1(i + 1, nums, tmpList, result);
        }
    }
}
