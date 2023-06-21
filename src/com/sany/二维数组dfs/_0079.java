package com.sany.二维数组dfs;

/**
 * 这题应该是hard
 */
public class _0079 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == words[0] && dfs(x, y, board, flag, words, 0)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private boolean dfs(int x, int y, char[][] board, boolean[][] flag, char[] words, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || flag[x][y]) {
            return Boolean.FALSE;
        }
        if (board[x][y] != words[index]) {
            return Boolean.FALSE;
        }
        if (index == words.length - 1) {
            return Boolean.TRUE;
        }
        flag[x][y] = Boolean.TRUE;
        boolean resultFlag = dfs(x - 1, y, board, flag, words, index + 1) ||
                dfs(x + 1, y, board, flag, words, index + 1) ||
                dfs(x, y - 1, board, flag, words, index + 1) ||
                dfs(x, y + 1, board, flag, words, index + 1);
        if (!resultFlag) {
            flag[x][y] = Boolean.FALSE;
        }
        return resultFlag;
    }

    public static void main(String[] args) {
        _0079 object = new _0079();
        char[][] board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','E','S'};
        board[2] = new char[]{'A','D','E','E'};
        System.out.println(object.exist(board, "ABCESEEEFS"));
    }
}
