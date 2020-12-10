package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NewCoderCircle2 {
    public static String solve (int[] param, Point[] edge) {
        int n=param[0];
        int edge_num=param[1];
        HashMap<Integer,LinkedList<Integer>> map=new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < edge.length; i++) {
            create_map(map,edge[i].x,edge[i].y);
            create_map(map,edge[i].y,edge[i].x);
        }
        HashMap<Integer,Integer> visited=new HashMap<Integer, Integer>();
        for (Integer v : map.keySet()) {
            visited.put(v,0);
        }

        if(dfs(map,visited,1,1))
        {
            return "Yes";
        }
        else
            return "No";
    }
    public static void create_map(HashMap<Integer,LinkedList<Integer>> map,int x,int y)
    {
        LinkedList<Integer> list;
        if(map.containsKey(x))
        {
            list=map.get(x);
        }
        else
        {
            list=new LinkedList<Integer>();
        }
        list.add(y);
        map.put(x,list);
    }
    public static boolean dfs(HashMap<Integer,LinkedList<Integer>> map,HashMap<Integer,Integer> visited,int c,int p){
        for (int i = 0; i < map.get(c).size(); i++) {
            int next=map.get(c).get(i);
            if(next==p)
                continue;
            if(next==1)
                return true;
            if(visited.get(next)==1)
                continue;
            visited.put(next,1);
            if(dfs(map,visited,next,c))
                return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] param={5,4};
        Point[] edges=new Point[4];
        edges[0]=new Point(1,3);
        edges[1]=new Point(3,4);
        edges[2]=new Point(4,5);
        edges[3]=new Point(5,6);

        System.out.println(solve(param,edges));
    }
}
