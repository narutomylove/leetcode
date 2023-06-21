package com.sany.二维数组dfs;

public class _0733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] flag = new boolean[image.length][image[0].length];
        dfs(sr, sc, image, flag, image[sr][sc], color);
        return image;
    }

    private void dfs(int x, int y, int[][] image, boolean[][] flag, int original, int color) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || flag[x][y] == Boolean.TRUE || image[x][y] != original) {
            return;
        }
        image[x][y] = color;
        flag[x][y] = Boolean.TRUE;
        dfs(x - 1, y, image, flag, original, color);
        dfs(x + 1, y, image, flag, original, color);
        dfs(x, y - 1, image, flag, original, color);
        dfs(x, y + 1, image, flag, original, color);
    }
}
