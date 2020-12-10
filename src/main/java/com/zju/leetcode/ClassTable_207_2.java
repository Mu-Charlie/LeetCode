package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class ClassTable_207_2 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //深度优先搜索检测环 栈实现
        //创建map
        LinkedList<Integer>[] map=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i]=new LinkedList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][1]].addFirst(prerequisites[i][0]);
        }
        int visited[]=new int[numCourses];
        Arrays.fill(visited,0);
        boolean hasCircle=false;
        for (int i = 0; i < numCourses; i++) {
            if(visited[i]!=0)
            {
                continue;
            }
            LinkedList<Integer> stack=new LinkedList<Integer>();
            stack.addFirst(i);
            while (!stack.isEmpty())
            {
                int cur_index=stack.getFirst();
                if(visited[cur_index]==0)
                {
                    cur_index=stack.getFirst();
                    visited[cur_index]=1;
                }
                else
                {
                    visited[cur_index]=2;
                    stack.removeFirst();
                    continue;
                }
                boolean flag=false;
                for (Integer next : map[cur_index]) {
                    if(visited[next]==1){
                        return false;
                    }
                    if(visited[next]==2)
                    {
                        continue;
                    }
                    else
                    {
                        flag=true;
                        stack.addFirst(next);
                    }
                }
                if(!flag)
                {
                    visited[cur_index]=2;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a={{1,2},{0,1},{2,3},{4,5},{3,4},{1,3}};
        System.out.println(canFinish(6,a));
        int[][]b={{1,0}};
        System.out.println(canFinish(2,b));
    }
}
