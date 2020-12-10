package com.zju.leetcode;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;

public class SearchBinaryMode {
    static int cur_max=0;
    static int last;
    static int count=0;
    static LinkedList<Integer> list=new LinkedList<>();
    public int[] findMode2(TreeNode root) {
        if(root==null)
        {
            return new int[0];
        }
        last=root.val;
        dfs2(root);
        if(count>=cur_max)
        {
            if(count>cur_max)
            {
                list.clear();
            }
            list.add(last);
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public void dfs2(TreeNode root)
    {
        if(root.left!=null)
        {
            dfs2(root.left);
        }
        if(root.val==last)
        {
            count+=1;
        }
        else
        {
            if(count>=cur_max)
            {
                if(count>cur_max)
                {
                    list.clear();
                }
                list.add(last);
                cur_max=count;
            }
            last=root.val;
            count=1;
        }
        if(root.right!=null)
        {
            dfs2(root.right);
        }
    }







    public int[] findMode(TreeNode root) {

        dfs(root,root.val);
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    public int dfs(TreeNode root,int val)
    {
        int left=0;
        int right=0;
        if(root.left!=null&&root.left.val==val)
        {
            left=dfs(root.left,val);
        }
        else if(root.left!=null)
        {
            dfs(root.left,root.left.val);
        }
        if(root.right!=null&&root.right.val==val)
        {
            right=dfs(root.right,val);
        }
        else if(root.right!=null)
        {
            dfs(root.right,root.right.val);
        }
        int num=left+right+1;
        if(num>=cur_max)
        {
            if(num>cur_max)
            {
                list=new LinkedList<>();
            }
            list.add(val);
            cur_max=num;
        }
        return num;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
//        root.right.right=new TreeNode(2);
        System.out.println(Arrays.toString(new SearchBinaryMode().findMode2(root)));
    }
}
