package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ClassTable_207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean visited[]=new boolean[numCourses];
        Arrays.fill(visited,false);
//        LinkedList<Integer>[] map=new LinkedList[numCourses];
        int[][] map=new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            Arrays.fill(map[i],0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
           map[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        int du[]=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                du[i]+=map[j][i];
            }
        }
        boolean flag[]=new boolean[numCourses];
        LinkedList<Integer> stack=new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(du[i]==0)
            {
                stack.addFirst(i);
            }
        }
        while (!stack.isEmpty())
        {
            int cur_index=stack.removeFirst();
            flag[cur_index]=true;
            for (int i = 0; i < numCourses; i++) {
                du[i]-=map[cur_index][i];
                if(map[cur_index][i]!=0&&du[i]==0)
                {
                    stack.add(i);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if(!flag[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourse=6;
        int[][] prerequisites={{1,2},{0,1},{2,3},{4,0},{3,4},{5,1}};
        System.out.println(canFinish(numCourse,prerequisites));
    }
}
