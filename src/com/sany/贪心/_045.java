package com.sany.贪心;

/**
 * 跳跃游戏
 */
public class _045 {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length - 1;
        int i = 0;
        int time = 0;   // 跳跃次数
        while (i < nums.length) {
            int step = nums[i];
            if (step == 0) {
                return 0;
            }
            int max = 0;
            int jump = 0;
            int total = 0;
            for (int j = step; j > 0; j--) {
                if (i + j >= length) {
                    return ++time;
                }
                total = j + nums[i + j];
                if (total > max) {
                    max = total;
                    jump = j;
                }
            }
            time++;
            i = i + jump;
        }
        return time;
    }

}
