package com.sany.回溯.子集与组合;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class _0216 {

    static int nums = 9;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        backTrack(1, n, k, deque, resultList);
        return resultList;
    }

    public static void backTrack(int begin, int target, int len, Deque<Integer> deque, List<List<Integer>> resultList) {
        if (target == 0 && deque.size() == len) {
            resultList.add(new ArrayList<>(deque));
            return;
        }
        if (target < 0 || deque.size() >= len) {
            return;
        }
        for (int i = begin; i <= nums; i++) {
            deque.add(i);
            backTrack(i + 1, target - i, len, deque, resultList);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3(9, 45);
    }
}
