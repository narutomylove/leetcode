package com.sany.tree;

/**
 * 二叉搜索树中第K小的元素
 */
public class _0230 {

    int num;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, k);
        if (++num == k) {
            result = node.val;
        }
        dfs(node.right, k);
    }
}
