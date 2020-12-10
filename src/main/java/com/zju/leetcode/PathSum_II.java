package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathSum_II {
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new LinkedList<>());
        return result;
    }
    public void dfs(TreeNode root,int target,List<Integer> temp)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==target&&root.left==null&&root.right==null)
        {
            temp.add(root.val);
            result.add(new LinkedList<>(temp));
            temp.remove(temp.size()-1);
        }
        else
        {
            temp.add(root.val);
            dfs(root.left,target-root.val,temp);
            dfs(root.right,target-root.val,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);
        List<List<Integer>> lists = new PathSum_II().pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
