package com.sany.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0354 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,7);
        int j = Collections.binarySearch(list, 5);
        System.out.println(j);
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] != arr2[0]) {
                return arr1[0] - arr2[0];
            }
            return arr2[1] - arr1[1];
        });
        List<Integer> nums = new ArrayList<>();
        nums.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > nums.get(nums.size() - 1)) {
                nums.add(envelopes[i][1]);
                continue;
            }
            int j = Collections.binarySearch(nums, envelopes[i][1]);
            nums.set(j < 0 ? -j - 1 : j, envelopes[i][1]);
        }
        return nums.size();
    }
}