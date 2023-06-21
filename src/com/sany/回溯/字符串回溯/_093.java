package com.sany.回溯.字符串回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 */
public class _093 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();
        backTrack(chars, 0, 0, list, resultList);
        resultList.forEach(v -> result.add(String.join(".", v)));
        return result;
    }

    private void backTrack(char[] chars, int begin, int len, List<String> list, List<List<String>> result) {
        int remain = chars.length - begin;
        if (remain < 4 - len || remain > 12 - 3 * len) {
            return;
        }
        if (len == 4 && begin == chars.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 取1个数
        list.add(String.valueOf(chars[begin]));
        backTrack(chars, begin + 1, len + 1, list, result);
        list.remove(list.size() - 1);
        // 取2个数
        if (chars[begin] == '0' || remain < 2) {
            return;
        }
        list.add(chars[begin] + String.valueOf(chars[begin + 1]));
        backTrack(chars, begin + 2, len + 1, list, result);
        list.remove(list.size() - 1);
        // 取3个数
        if (remain < 3) {
            return;
        }
        String num3 = chars[begin] +
                String.valueOf(chars[begin + 1]) + chars[begin + 2];
        if (Integer.valueOf(num3) > 255) {
            return;
        }
        list.add(num3);
        backTrack(chars, begin + 3, len + 1, list, result);
        list.remove(list.size() - 1);
    }
}
