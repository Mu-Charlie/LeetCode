package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NewCoderCircle3 {
    public static String solve (int[] param, Point[] edge) {
        int n=param[0];
        int edge_num=param[1];
        LinkedList<Integer>[] map=new LinkedList[100005];

        for (int i = 0; i < edge_num; i++) {
            if(map[edge[i].x]==null)
            {
                map[edge[i].x]=new LinkedList<Integer>();
            }
            map[edge[i].x].add(edge[i].y);
            if(map[edge[i].y]==null)
            {
                map[edge[i].y]=new LinkedList<Integer>();
            }
            map[edge[i].y].add(edge[i].x);
        }
        int visited[]=new int[100005];
        Arrays.fill(visited,0);
        if(dfs(map,visited,1,1))
        {
            return "Yes";
        }
        else
            return "No";
    }
    public static boolean dfs(LinkedList<Integer>[]  map,int[] visited,int c,int p){
        for (int i = 0; i < map[c].size(); i++) {
            int next=map[c].get(i);
            if(next==p)
                continue;
            if(next==1)
                return true;
            if(visited[next]==1)
                continue;
            visited[next]=1;
            if(dfs(map,visited,next,c))
                return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] param={4,4};
        Point[] edges=new Point[4];
        edges[0]=new Point(1,3);
        edges[1]=new Point(3,4);
        edges[2]=new Point(4,5);
        edges[3]=new Point(5,1);

        System.out.println(solve(param,edges));
    }
}
