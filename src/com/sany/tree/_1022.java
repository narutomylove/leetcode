package com.sany.tree;

public class _1022 {

    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num = node.val + num * 2;
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }
        dfs(node.left, num);
        dfs(node.right, num);
    }
}
