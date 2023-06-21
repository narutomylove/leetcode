package com.sany.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列问题，easy
 */
public class _0869 {

    public boolean reorderedPowerOf2(int n) {
        List<Integer> element = new ArrayList<>();
        while (n > 0) {
            element.add(n % 10);
            n = n / 10;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[element.size()];
        return backTrack(element, list, flag);
    }

    private boolean backTrack(List<Integer> element, List<Integer> list, boolean[] flag) {
        if (list.size() == element.size()) {
            if (isPowerOfTwo(listToNum(list))) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        boolean result = Boolean.FALSE;
        for (int i = 0; i < element.size(); i++) {
            if (flag[i]) {
                continue;
            }
            if (element.get(i) == 0 && list.size() < 1) {
                continue;
            }
            list.add(element.get(i));
            flag[i] = Boolean.TRUE;
            result |= backTrack(element, list, flag);
            flag[i] = Boolean.FALSE;
            list.remove(list.size() - 1);
        }
        return result;
    }

    private int listToNum(List<Integer> list) {
        int num = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int index = list.size() - i - 1;
            num += list.get(index) * Math.pow(10, i);
        }
        return num;
    }

    private boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        _0869 object = new _0869();
        List<Integer> list = Arrays.asList(1,0,3,4);
        int num = object.listToNum(list);
        System.out.println(num);
        boolean flag = object.reorderedPowerOf2(4103);
        System.out.println(flag);
    }
}
