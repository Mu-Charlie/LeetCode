package com.zju.leetcode;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Rob3_337 {
    public static int rob(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        LinkedList<Integer> layer_income=new LinkedList<Integer>();
        while (!queue.isEmpty())
        {
            int size=queue.size();
            int income=0;
            for (int i = 0; i < size; i++) {
                TreeNode cur_node=queue.remove();
                if(cur_node.left!=null)
                {
                    queue.add(cur_node.left);
                }
                if(cur_node.right!=null)
                {
                    queue.add(cur_node.right);
                }
                income+=cur_node.val;
            }
            layer_income.add(income);
        }
        int[] dp=new int[layer_income.size()];
        Arrays.fill(dp,0);
        if(dp.length==0)
        {
            return 0;
        }
        else if(dp.length==1)
        {
            return layer_income.get(0);
        }
        else if(dp.length==2)
        {
            return Math.max(layer_income.get(0),layer_income.get(1));
        }
        else if(dp.length==3)
        {
            return Math.max(layer_income.get(1),layer_income.get(0)+layer_income.get(2));
        }
        dp[0]=layer_income.get(0);
        dp[1]=layer_income.get(1);
        dp[2]=layer_income.get(0)+layer_income.get(2);
        int max_value=0;
        max_value=Math.max(dp[1],dp[2]);
        for (int i = 3; i < layer_income.size(); i++) {
            dp[i]=Math.max(dp[i-2],dp[i-3])+layer_income.get(i);
            if(dp[i]>max_value)
            {
                max_value=dp[i];
            }
        }
        return max_value;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(30);
        root.left=left;
        root.right=right;
        left.right=new TreeNode(3);
        left.right.left=new TreeNode(10);
        right.right=new TreeNode(1);
        System.out.println(rob(root));
    }
}
