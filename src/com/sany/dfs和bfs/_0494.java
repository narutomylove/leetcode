package com.sany.dfs和bfs;

public class _0494 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0,0, target);
    }

    private int dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(nums, index + 1, sum + nums[index], target) +
                dfs(nums, index + 1, sum - nums[index], target);
    }
}
