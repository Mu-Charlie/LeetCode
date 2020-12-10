package com.zju.leetcode;

import sun.nio.cs.ext.MacHebrew;

public class CameraBinaryTree {
    public int minCameraCover(TreeNode root) {
        int[] list=dfs(root);
        return list[1];
    }
    public int[] dfs(TreeNode root)
    {
        if(root==null)
        {
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        int[] leftlist=dfs(root.left);
        int[] rightlist=dfs(root.right);
        int[] list=new int[3];
        list[0]=leftlist[2]+rightlist[2]+1;
        list[1]=Math.min(list[0], Math.min(leftlist[0]+rightlist[1],rightlist[0]+leftlist[1]));
        list[2]=Math.min(list[0],leftlist[1]+rightlist[1]);
        return list;
    }
}
