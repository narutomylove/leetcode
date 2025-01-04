package com.sany.回溯.子集与组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集2
 */
public class _0090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        resultList.add(list);
        Arrays.sort(nums);
        backTrack(0, nums, list, resultList);
        return resultList;
    }

    public void backTrack(int begin, int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> nextList = new ArrayList<>(list);
            nextList.add(nums[i]);
            resultList.add(nextList);
            backTrack(i + 1, nums, nextList, resultList);
        }
    }
}
