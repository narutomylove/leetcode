package com.sany.回溯.子集与组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 78子集1、90子集2
 */
public class _0078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        resultList.add(list);
        backTrack(0, nums, list, resultList);
        return resultList;
    }

    private void backTrack(int begin, int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        for (int i = begin; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            resultList.add(newList);
            backTrack(i + 1, nums, newList, resultList);
        }
    }
}
