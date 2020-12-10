package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WeekContest199_3 {
    public void travel(TreeNode root,int dis[][])
    {

    }
    public int countPairs(TreeNode root, int distance) {
        int dis[][]=new int[1024][1024];
        for (int i = 0; i < 1024; i++) {
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<TreeNode> leaflist=new ArrayList<TreeNode>();
        stack.push(root);
        int index=0;
        while(!stack.empty())
        {
            int child=0;
            TreeNode node=stack.pop();
            if(node.left==null&&node.right==null)
            {
                leaflist.add(node);
            }
            else{
                if(node.left!=null)
                {
                    child++;
                    stack.push(node.left);
                }
                if(node.right!=null)
                {
                    stack.push(node.right);
                }
            }

            index++;
        }
        return 0;
    }
}
