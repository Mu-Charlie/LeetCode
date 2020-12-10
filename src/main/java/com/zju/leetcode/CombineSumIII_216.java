package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombineSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new LinkedList<>();
        boolean flag[]=new boolean[11];
        dfs(k,n,1,result,flag);
        return result;
    }
    public void dfs(int k,int n,int i,List<List<Integer>> result,boolean[] flag)
    {
        if(i>10)
        {
            return;
        }
        if(k==0)
        {
            if(n==0)
            {
//                flag[i]=true;
                List<Integer> list=new LinkedList<>();
                for (int j = 0; j < flag.length; j++) {
                    if(flag[j])
                    {
                        list.add(j);
                    }
                }
//                flag[i]=false;
                result.add(list);
            }
            return;
        }
        if(n>=i)
        {
            flag[i]=true;
            dfs(k-1,n-i,i+1,result,flag);
            flag[i]=false;
        }
        dfs(k,n,i+1,result,flag);
    }

    public static void main(String[] args) {
        List<List<Integer>> result=new CombineSumIII_216().combinationSum3(3, 15);
        for (List<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }
}
