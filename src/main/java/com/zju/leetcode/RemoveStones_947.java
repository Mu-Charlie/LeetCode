package com.zju.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RemoveStones_947 {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        // build map
        LinkedList<LinkedList<Integer>> edges=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new LinkedList<>());
        }

        HashMap<Integer,LinkedList<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(stones[i][0]))
            {
                map.put(stones[i][0],new LinkedList<>());
            }
            map.get(stones[i][0]).add(i);
            if(!map.containsKey(stones[i][1]+10001))
            {
                map.put(stones[i][1]+10001,new LinkedList<>());
            }
            map.get(stones[i][1]+10001).add(i);
        }
        for (Integer integer : map.keySet()) {
            LinkedList<Integer> list=map.get(integer);
            int k=list.size();
            for (int i = 1; i < k; i++) {
                edges.get(list.get(i-1)).add(list.get(i));
                edges.get(list.get(i)).add(list.get(i-1));
            }
        }
        boolean flag[]=new boolean[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            if(!flag[i])
            {
                count++;
                dfs(i,edges,flag);
            }
        }
        return n-count;
    }
    private void dfs(int index,LinkedList<LinkedList<Integer>> edges,boolean[] flag)
    {
        flag[index]=true;
        for (Integer integer : edges.get(index)) {
            if(!flag[integer])
            {
                dfs(integer,edges,flag);
            }
        }
    }
}
