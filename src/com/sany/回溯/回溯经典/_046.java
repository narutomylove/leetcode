package com.sany.回溯.回溯经典;

import java.util.*;

/**
 * 回溯算法经典：全排列
 * 没做过还是真是不会写
 * 46、47、60 三题和一起看
 */
public class _046 {

    /**
     * 基础版全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        boolean[] numFlag = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        backTrack(nums, numFlag, deque, list);
        return list;
    }

    public void backTrack(int[] nums, boolean[] numFlag, Deque<Integer> deque, List<List<Integer>> list) {
        if (deque.size() == nums.length) {
            list.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < nums.length; i++) {
            if (numFlag[i]) {
                continue;
            }
            deque.add(nums[i]);
            numFlag[i] = true;
            backTrack(nums, numFlag, deque, list);
            deque.pollLast();
            numFlag[i] = false;
        }
    }

    /**
     * 第60题，其实没啥意思。和46题一模一样
     */
    public String getPermutation(int n, int k) {
        boolean[] flag = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> allList = new ArrayList<>();
        backTrack(n, k, flag, list, allList);
        StringBuilder sb = new StringBuilder();
        allList.get(k - 1).forEach(v -> sb.append(v));
        return sb.toString();
    }

    private void backTrack(int n, int k, boolean[] flag, List<Integer> list, List<List<Integer>> allList) {
        if (list.size() == n) {
            allList.add(new ArrayList<>(list));
        }
        if (allList.size() == k) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (flag[i] == Boolean.TRUE) {
                continue;
            }
            list.add(i);
            flag[i] = Boolean.TRUE;
            backTrack(n, k, flag, list, allList);
            flag[i] = Boolean.FALSE;
            list.remove(list.size() - 1);
        }
    }


}
