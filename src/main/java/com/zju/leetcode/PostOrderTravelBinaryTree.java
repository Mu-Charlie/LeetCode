package com.zju.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PostOrderTravelBinaryTree {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left,result);
        dfs(root.right,result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        System.out.println(new PostOrderTravelBinaryTree().postorderTraversal(root).toString());
    }
}
