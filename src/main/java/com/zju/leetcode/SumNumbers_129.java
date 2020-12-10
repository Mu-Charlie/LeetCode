package com.zju.leetcode;

public class SumNumbers_129 {
//    static int result;
    public int sumNumbers(TreeNode root) {
        int result=0;
        if(root!=null)
        {
            result=recursive_sum(root,0,0);
        }
        return result;
    }
    public int recursive_sum(TreeNode root,int temp,int result)
    {
        temp=temp*10+root.val;
        if(root.left==null&&root.right==null)
        {
            result+=temp;
        }
        if(root.left!=null)
        {
            result=recursive_sum(root.left,temp,result);
        }
        if(root.right!=null)
        {
            result=recursive_sum(root.right,temp,result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(9);
        root.right=new TreeNode(0);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(1);
//        root=null;
        System.out.println(new SumNumbers_129().sumNumbers(root));
    }
}
