package com.sany.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 第13题
 */
public class _013JZO {

    /**
     * 这个是最优解，但是比较难
     */
    class Solution {
        int m, n, k;
        boolean[][] visited;
        public int movingCount(int m, int n, int k) {
            this.m = m; this.n = n; this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }
        public int dfs(int i, int j, int si, int sj) {
            if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }
    }

    /**
     * dfs
     * 不是最优解，但是是最容易理解的版本
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || sum(i, j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    private int sum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    /**
     * bfs 版本
     */
    public int movingCountBFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        deque.offer(0);
        int total = 0;
        while (!deque.isEmpty()) {
            int i = deque.poll();
            int j = deque.poll();
            if (i >= m || j >= n || sum(i, j) > k || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            total++;
            deque.offer(i + 1);
            deque.offer(j);
            deque.offer(i);
            deque.offer(j + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        _013JZO object = new _013JZO();
        System.out.println(object.movingCount(38, 15, 9));
    }
}
