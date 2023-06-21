package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;

/**
 * 求根节点到叶子节点数字之和
 * 这题也是非常典型啊
 */
public class _129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int value) {
        if (node == null) {
            return 0;
        }
        int tmp = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            return tmp;
        }
        return dfs(node.left, tmp) + dfs(node.right, tmp);
    }
}
