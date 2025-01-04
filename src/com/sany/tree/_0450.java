package com.sany.tree;

/**
 * 这道题很重要，会写这题就算是掌握了 DFS 精髓
 */
public class _0450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val == key) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            TreeNode tmp = node.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = node.right;
            return node.left;
        }
        if (node.val > key) {
            node.left = dfs(node.left, key);
        } else {
            node.right = dfs(node.right, key);
        }
        return node;
    }
}
