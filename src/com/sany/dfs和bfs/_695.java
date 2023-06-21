package com.sany.dfs和bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 经典岛屿问题之：最大岛屿
 */
public class _695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j ++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i, j + 1);
        return num;
    }

    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());
    }

    // BFS解法
    public int bfs(int[][] grid, int i, int j) {
        int num = 0;
        if (grid[i][j] == 0) {
            return num;
        }
        grid[i][j] = num++;
        deque.offer(i);
        deque.offer(j);
        while (!deque.isEmpty()) {
            int x = deque.poll();
            int y = deque.poll();
            if (x > 0 && grid[x - 1][y] == 1) {
                deque.offer(x - 1);
                deque.offer(y);
                num++;
            }
            if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                deque.offer(x + 1);
                deque.offer(y);
                num++;
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                deque.offer(x);
                deque.offer(y - 1);
                num++;
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                deque.offer(x);
                deque.offer(y + 1);
                num++;
            }
        }
        return num;
    }
}
