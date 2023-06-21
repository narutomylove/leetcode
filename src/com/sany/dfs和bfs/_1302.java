package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;

public class _1302 {

    private int maxLevel = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            maxLevel = level;
            sum = 0;
        }
        if (maxLevel == level) {
            sum += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
