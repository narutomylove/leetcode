package com.sany.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 岛屿数量
 */
public class _200 {

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(i, j, grid);
                }
            }
        }
        return num;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    /**
     * bfs实现
     */
    public int numIslandsBFS(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(i, j, grid);
                }
            }
        }
        return num;
    }

    private void bfs(int m, int n, char[][] grid) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(m);
        deque.offer(n);
        while (!deque.isEmpty()) {
            int i = deque.poll();
            int j = deque.poll();
            grid[i][j] = '0';
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                deque.offer(i - 1);
                deque.offer(j);
            }
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                deque.offer(i + 1);
                deque.offer(j);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                deque.offer(i);
                deque.offer(j - 1);
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                deque.offer(i);
                deque.offer(j + 1);
            }
        }
    }

}
