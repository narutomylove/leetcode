package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;

public class _1022 {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int tmp = num * 2 + node.val;
        if (node.left == null && node.right == null) {
            return tmp;
        }
        return dfs(node.left, tmp) + dfs(node.right, tmp);
    }
}
