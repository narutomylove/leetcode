package com.sany.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 这道题看起来很傻逼，其实挺考验二叉树基础的
 */
public class _1104 {

    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));
        List<Integer> result = new ArrayList<>(level + 1);
        result.add(label);
        while (label > 1) {
            int levelMax = (int) Math.pow(2, level) - 1;
            int levelMin = (int) Math.pow(2, --level);
            label = levelMax + levelMin - label / 2;
            result.add(label);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int level = (int) (Math.log(5) / Math.log(2));
        System.out.println(level);
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
