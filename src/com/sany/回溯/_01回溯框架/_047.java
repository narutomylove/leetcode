package com.sany.回溯._01回溯框架;

import java.util.*;

/**
 * 带重复数字的全排列
 */
public class _047 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        boolean[] flag = new boolean[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, flag, deque, list, 0);
        return list;
    }

    public static void backTrack(int nums[], boolean[] flag, Deque<Integer> deque, List<List<Integer>> list, int depth) {
        if (deque.size() == nums.length) {
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = Boolean.TRUE;
            deque.add(nums[i]);
            backTrack(nums, flag, deque, list, depth++);
            depth--;
            deque.pollLast();
            flag[i] = Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }

    /**
     * 带重复数字全排列变式：1079
     * 注意：这题只求数量即可
     */
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] flag = new boolean[chars.length];
        //Deque<Character> deque = new ArrayDeque<>();
        //List<List<Character>> list = new ArrayList<>();
        int total = backTrack(chars, flag);
        return total;
    }

    private int backTrack(char[] chars, boolean[] flag) {
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1]) {
                continue;
            }
            //deque.addLast(chars[i]);
            flag[i] = Boolean.TRUE;
            total = total + backTrack(chars, flag) + 1;
            flag[i] = Boolean.FALSE;
            //deque.pollLast();
        }
        return total;
    }
}
