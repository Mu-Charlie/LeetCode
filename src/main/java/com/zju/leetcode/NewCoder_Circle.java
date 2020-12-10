package com.zju.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NewCoder_Circle {
    public static String solve (int[] param, Point[] edge) {
        // write code here
        if(param[1]==0)
        {
            return "No";
        }
        HashMap<Integer,LinkedList<Integer>> map=new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < param[0]; i++) {
            map.put(i+1,new LinkedList<Integer>());
        }
        for (int i = 0; i < edge.length; i++) {
            create_map(map,edge[i].x,edge[i].y);
            create_map(map,edge[i].y,edge[i].x);
        }
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.addAll(0,map.get(1));
//        list.addAll(0,map.get(2));
//        System.out.println(Arrays.toString(list.toArray()));
        int[] flag=new int[param[0]+1];

        Arrays.fill(flag,0);
        flag[1]=1;
        boolean hascircle=false;
        int last=1;
        while (list.size()!=0)
        {
            int cur_index=list.getFirst();
            list.removeFirst();
            if(flag[cur_index]!=0)
            {
                continue;
            }
            flag[cur_index]=1;
            for (int i = 0; i < map.get(cur_index).size(); i++) {
//                int next=map.get(cur_index).get(i);
//                if(flag[next]==0)
//                {
//                    list.addFirst(next);
////                    flag[next]=1;
//                }
//                else if(next==1&&next!=last)
//                {
//                    hascircle=true;
//                    break;
//                }
                int next=map.get(cur_index).get(i);
                if(next==last)
                {
                    continue;
                }
                if(next==1)
                {
                    hascircle=true;
                    break;
                }
                if(flag[next]==1)
                {
                    continue;
                }
                else {
                    flag[next]=1;
                    list.addFirst(next);
                }

            }
            if(hascircle)
            {
                break;
            }
            last=cur_index;
        }
        if(hascircle)
        {
            return "Yes";
        }
        else {
            return "No";
        }
    }
    public static void create_map(HashMap<Integer,LinkedList<Integer>> map,int x,int y)
    {
        LinkedList<Integer> list=map.get(x);
        list.add(y);
        map.put(x,list);
    }

    public static void main(String[] args) {
        int[] param={5,4};
        Point[] edges=new Point[4];
        edges[0]=new Point(1,2);
        edges[1]=new Point(2,3);
        edges[2]=new Point(3,4);
        edges[3]=new Point(4,5);

        System.out.println(solve(param,edges));
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}