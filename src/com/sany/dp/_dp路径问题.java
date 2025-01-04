package com.sany.dp;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最基础的 dp 问题，路径问题。
 * leetcode.62、63、64、120、931、1289、1575、576、1301
 * 必须值得二刷的题：1575（DFS解法和DP解法都要学会）
 */
public class _dp路径问题 {

    /**
     * 62.不同的路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    /**
     * 62.空间优化版本
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 63题 爬楼梯
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    // 63题：空间优化版本
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length + 1];
        for (int j = 1; j <= obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j - 1] == 1) {
                break;
            }
            dp[j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j - 1] == 1) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] += dp[j - 1];
            }
        }
        return dp[obstacleGrid[0].length];
    }

    /**
     * 64题 62题的进阶版本
     * 这个版本的解法是刚刷完 dfs 时候想到的解法，leetcode显示的执行时间和内存均优于下面的dp解法。（小优一丢丢，差不多）
     */
    public int minPathSum(int[][] grid) {
        return dfs(grid.length - 1, grid[0].length - 1, grid, new int[grid.length][grid[0].length]);
    }

    private int dfs(int m, int n, int[][] grid, int[][] cache) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (cache[m][n] > 0) {
            return cache[m][n];
        }
        int num = grid[m][n] + Math.min(dfs(m -1, n, grid, cache), dfs(m, n - 1, grid, cache));
        cache[m][n] = num;
        return num;
    }

    /**
     * 62、63 ——> 64 一脉相承的 dp 解法
     */
    public int minPathSum1(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        for (int i = 0; i < grid[0].length; i++) {
            dp[i + 1] = dp[i] + grid[0][i];
        }
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[j + 1] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 120.三角形最小路径和。和64题一摸一样的套路
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] list = new int[1];
        list[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int[] nList = new int[list.length + 1];
            List<Integer> sList = triangle.get(i);
            for (int j = 0; j < sList.size(); j++) {
                if (j == 0) {
                    nList[j] = list[j] + sList.get(j);
                    continue;
                }
                if (j == sList.size() - 1) {
                    nList[j] = list[j - 1] + sList.get(j);
                    continue;
                }
                nList[j] = Math.min(list[j - 1], list[j]) + sList.get(j);
            }
            list = nList;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            min = min < list[i] ? min : list[i];
        }
        return min;
    }

    /**
     * 931. 下降路径最小和
     */
    public static int minFallingPathSum(int[][] matrix) {
        int len = matrix[0].length;
        int[] nums = new int[len + 2];
        System.arraycopy(matrix[0], 0 , nums, 1, len);
        nums[0] = nums[len + 1] = Integer.MAX_VALUE;
        int pre = 0;
        int now = 0;
        for (int i = 1; i < matrix.length; i++) {
            pre = nums[0];
            for (int j = 0; j < len; j++) {
                now = nums[j + 1];
                nums[j + 1] = Math.min(pre, Math.min(nums[j + 1], nums[j + 2])) + matrix[i][j];
                pre = now;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++ ) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    /**
     * (Hard)1289.下降路径最小和(下降时，相邻数字不能选同一列，注意了：但是可以选隔得很远的其他列)
     * 其实就是变一下而已，没那么难
     */
    public static int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int[][] nums = new int[n][n];
        System.arraycopy(grid[0], 0, nums[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    min = Math.min(min, nums[i - 1][k]);
                }
                nums[i][j] = min + grid[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[n - 1][i]);
        }
        return min;
    }

    /**
     * (Hard)1575. 统计所有可行路径
     * 方法一：DFS记忆化搜索（真是不好理解，注意分析别老把DFS和回溯混为一谈了，这里需要回溯吗？不需要，所以用DFS解决）
     */
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] cache = new int[locations.length][fuel + 1];
        for (int[] sub : cache) {
            Arrays.fill(sub, -1);
        }
        int sum = dfs(locations, start, finish, fuel, cache);
        return sum;
    }

    private int dfs(int[] locations, int start, int finish, int fuel, int[][] cache) {
        if (cache[start][fuel] != -1) {
            return cache[start][fuel];
        }
        int need = Math.abs(locations[finish] - locations[start]);
        if (need > fuel) {
            cache[start][fuel] = 0;
            return 0;
        }
        int sum = start == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i == start) {
                continue;
            }
            need = Math.abs(locations[start] - locations[i]);
            if (need > fuel) {
                continue;
            }
            sum += dfs(locations, i, finish, fuel - need, cache);
            sum %= 1000000007;
        }
        cache[start][fuel] = sum;
        return sum;
    }

    /**
     * 1575 的 DP 解法，非常经典的题目，要仔细啃。
     */
    public int countRoutes2(int[] ls, int start, int end, int fuel) {
        int n = ls.length;

        // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        int[][] f = new int[n][fuel + 1];

        // 对于本身位置就在目的地的状态，路径数为 1(这是解本体关键)
        for (int i = 0; i <= fuel; i++) f[end][i] = 1;

        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(ls[i] - ls[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur-need];
                            f[i][cur] %= 1000000007;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }

    /**
     * 576. 出界的路径数
     * 这题用dp特别不好理解，用记忆化搜索好理解
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int) 1e9+7;
        int[][][] cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, startRow, startColumn, maxMove, cache, mod);
    }

    private int dfs(int m, int n, int x, int y, int maxMove, int[][][] cache, int mod) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (maxMove == 0) {
            cache[x][y][maxMove] = 0;
            return 0;
        }
        if (cache[x][y][maxMove] != -1) {
            return cache[x][y][maxMove];
        }
        int nums = 0;
        nums += dfs(m, n, x - 1, y, maxMove - 1, cache, mod);
        nums %= mod;
        nums += dfs(m, n, x + 1, y, maxMove - 1, cache, mod);
        nums %= mod;
        nums += dfs(m, n, x, y - 1, maxMove - 1, cache, mod);
        nums %= mod;
        nums += dfs(m, n, x, y + 1, maxMove - 1, cache, mod);
        nums %= mod;
        cache[x][y][maxMove] = nums;
        return nums;
    }

    /**
     * 1301.
     */
    public int[] pathsWithMaxScore(List<String> board) {
        return null;
    }

    public static void main(String[] args) {
        int[] matrix = {2,3,6,8,4};
    }
}
