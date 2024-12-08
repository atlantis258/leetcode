package com.atlantis.tree;

// 543.二叉树的直径
// https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
public class DiameterOfBinaryTree {
    int ans;

    // 深度优先搜索
    //
    // 一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
    // 而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树 的深度
        int R = depth(node.right); // 右儿子为跟的子树 的深度
        ans = Math.max(ans, L+R+1); // 计算d_node 即 L+R+1 并更新 ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树 的深度
    }
}
