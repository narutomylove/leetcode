package com.sany.回溯.回溯游戏;

import java.util.*;

/**
 * 智商检测题：N皇后问题
 */
public class _051 {

    private int n;
    // 列是否有皇后标志位
    private boolean[] listFlag;
    // 主对角线是否有皇后标志位
    private boolean[] dia;
    // 副主对角线是否有皇后标志位
    private boolean[] seDia;
    private List<List<String>> result;
    private Deque<Integer> res;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        this.n = n;
        result = new ArrayList<>();
        res = new ArrayDeque<>();
        listFlag = new boolean[n];
        int allLen = 2 * n - 1;
        dia = new boolean[allLen];
        seDia = new boolean[allLen];

        backTrack(0);
        return result;
    }

    private void backTrack(int row) {
        if (row == n) {
            List<String> choice = getChoice(res);
            result.add(choice);
            return;
        }
        for (int i = 0; i < n; i++) {
            // !列被选过 && !主对角线上有了 && !副对角线上有了
            if (!listFlag[i] && !dia[row - i + n - 1] && !seDia[row + i]) {
                listFlag[i] = Boolean.TRUE;
                dia[row - i + n - 1] = Boolean.TRUE;
                seDia[row + i] = Boolean.TRUE;
                res.add(i);
                backTrack(row + 1);
                listFlag[i] = Boolean.FALSE;
                dia[row - i + n - 1] = Boolean.FALSE;
                seDia[row + i] = Boolean.FALSE;
                res.pollLast();
            }
        }
    }

    private List<String> getChoice(Deque<Integer> res) {
        List<String> onceChoice = new ArrayList<>();
        for (Integer num : res) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[num] = 'Q';
            onceChoice.add(new String(chars));
        }
        return onceChoice;
    }

    public static void main(String[] args) {
        //_051 test = new _051();
        //test.solveNQueens(4);

        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING    = -1 << COUNT_BITS;
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(RUNNING));
        int SHUTDOWN   =  0 << COUNT_BITS;
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        int STOP       =  1 << COUNT_BITS;
        System.out.println(Integer.toBinaryString(STOP));
        int TIDYING    =  2 << COUNT_BITS;
        System.out.println(Integer.toBinaryString(TIDYING));
        int TERMINATED =  3 << COUNT_BITS;
        System.out.println(Integer.toBinaryString(TERMINATED));
        System.out.println(Integer.toBinaryString((1 << COUNT_BITS) - 1));
        System.out.println(Integer.toBinaryString((1 << COUNT_BITS) - 1).length());

    }
}
