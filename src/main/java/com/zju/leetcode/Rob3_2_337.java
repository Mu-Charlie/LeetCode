package com.zju.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

public class Rob3_2_337 {
    public static int rob(TreeNode root) {
        HashMap<TreeNode,Integer> white=new HashMap<TreeNode, Integer>();
        HashMap<TreeNode,Integer> black=new HashMap<TreeNode, Integer>();
        dfs(root,white,black);
        return Math.max(white.getOrDefault(root,0),black.getOrDefault(root,0));
    }
    public static void dfs(TreeNode root, HashMap<TreeNode,Integer> w,HashMap<TreeNode,Integer> b)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left,w,b);
        dfs(root.right,w,b);
        //不选择当前节点，也即当前节点为白色，那左右孩子分别可以是 黑黑 白黑 黑白
        w.put(root,Math.max(Math.max(b.getOrDefault(root.left,0)+b.getOrDefault(root.right,0),Math.max(b.getOrDefault(root.left,0)+w.getOrDefault(root.right,0),w.getOrDefault(root.left,0)+b.getOrDefault(root.right,0))),w.getOrDefault(root.left,0)+w.getOrDefault(root.right,0)));
        //选择当前节点，也即当前节点为黑色，那孩子只能是 白白
        b.put(root,root.val+w.getOrDefault(root.left,0)+w.getOrDefault(root.right,0));
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        TreeNode left=new TreeNode(1);
        TreeNode right=new TreeNode(3);
        root.left=left;
        root.right=right;
        left.right=new TreeNode(4);
        System.out.println(rob(root));
    }
}
