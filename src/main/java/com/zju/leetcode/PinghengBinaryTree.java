package com.zju.leetcode;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class PinghengBinaryTree {
    static boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        heightMinus(root);
        if(flag)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int heightMinus(TreeNode root)
    {
        if(flag)
        {
            if(root==null)
            {
                return 0;
            }
            int leftHeight=heightMinus(root.left);
            int rightHeight=heightMinus(root.right);
            if(Math.abs(leftHeight-rightHeight)>1)
            {
                flag=false;
            }
            return Math.max(leftHeight,rightHeight)+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PinghengBinaryTree().isBalanced(null));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}

