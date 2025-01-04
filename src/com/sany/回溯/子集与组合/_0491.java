package com.sany.回溯.子集与组合;

import java.util.*;

/**
 * 返回所有的递增子序列
 */
public class _0491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Deque<Integer> list = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(0, nums, list, resultList);
        return resultList;
    }

    private void backTrack(int begin, int[] nums, Deque<Integer> list, List<List<Integer>> resultList) {
        if (list.size() > 1) {
            resultList.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (list.size() > 0 && nums[i] < list.peekLast()) {
                continue;
            }
            set.add(nums[i]);
            list.add(nums[i]);
            backTrack(i + 1, nums, list, resultList);
            list.pollLast();
        }
    }
}
