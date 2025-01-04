package com.sany.dp;

/**
 * 跳台阶问题，不是那么简单，单开一个文件写
 */
public class _0045 {

    /**
     * 55:跳跃游戏一
     */
    public boolean canJump(int[] nums) {
        int next = 0;
        int target = nums.length - 1;
        for (int i = 0; i <= next; i++) {
            next = Math.max(next, i + nums[i]);
            if (next >= target) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 45*：跳跃游戏二
     */
    public int jump(int[] nums) {
        int start = 0;
        int end = 1;
        int max = 0;
        int step = 0;
        while (end < nums.length) {
            for (int i = start; i < end; i++) {
                max = Math.max(max, nums[i] + i);
            }
            step++;
            start = end;
            end = max + 1;
        }
        return step;
    }
}
