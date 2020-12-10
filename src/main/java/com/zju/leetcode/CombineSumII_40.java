package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombineSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new LinkedList<>();
        Arrays.sort(candidates);
        boolean flag[]=new boolean[candidates.length];
        dfs(result,flag,candidates,0,target);
        return result;
    }
    public void dfs(List<List<Integer>> result,boolean[] temp,int[]candidates,int start,int target)
    {
        if(start>=temp.length)
        {
            return;
        }
        if(target-candidates[start]>=0)//能放得下当前元素
        {
            temp[start] = true;
            if (target - candidates[start] == 0)//等于target
            {
                LinkedList<Integer> list = new LinkedList<>();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j]) {
                        list.add(candidates[j]);
                    }
                }
                result.add(list);
                temp[start] = false;
                return;
            }
            int next=start+1;
//            while (next<temp.length&&candidates[next]==candidates[start])
//                next++;
            dfs(result,temp,candidates,next,target-candidates[start]);
            temp[start]=false;
        }
        int next=start+1;
        while (next<temp.length&&candidates[next]==candidates[start])
            next++;
        dfs(result,temp,candidates,next,target);

    }

    public static void main(String[] args) {
        int[] candidates={2,5,2,1,2};
        int target=5;
        List<List<Integer>> list=new CombineSumII_40().combinationSum2(candidates, target);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }
}
