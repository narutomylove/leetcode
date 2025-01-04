package com.sany.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> nodeMap = new HashMap<>();
        List<TreeNode> nodeList = new ArrayList<>();
        dfs(root, nodeMap, nodeList);
        return nodeList;
    }

    private String dfs(TreeNode node, Map<String, Integer> nodeMap, List<TreeNode> nodeList) {
        if (node == null) {
            return "";
        }
        String leftString = dfs(node.left, nodeMap, nodeList);
        String rightString = dfs(node.right, nodeMap, nodeList);
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",").append(leftString).append(",").append(rightString);
        String nodeString = sb.toString();
        if (nodeMap.getOrDefault(nodeString, 0) == 1) {
            nodeList.add(node);
        }
        nodeMap.put(nodeString, nodeMap.getOrDefault(nodeString, 0) + 1);
        return nodeString;
    }
}
