package com.sany.dp;

/**
 * 经典题：最长递增子序列
 */
public class _0300 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        return fibRe(n, cache);
    }

    private int fibRe(int n, int[] cache) {
        if (cache[n] > 0) {
            return cache[n];
        }
        int fib = fibRe(n - 1, cache) + fibRe(n - 2, cache);
        cache[n] = fib;
        return fib;
    }

    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int prePre = 0;
        int pre = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
