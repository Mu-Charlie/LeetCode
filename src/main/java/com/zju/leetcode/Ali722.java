package com.zju.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ali722 {
    public static void main(String[] args) {
        int n;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        int flags[]=new int[n];
        Arrays.fill(flags,0);
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> total_list=new ArrayList<ArrayList<Integer>>();
        search(flags,list);
//        for (ArrayList<Integer> integers : total_list) {
//            System.out.println(integers);
//        }
    }
    public static void search(int flag[],ArrayList<Integer> list)
    {
        if(list.size()==flag.length)
        {
//            System.out.println("add..");
            System.out.println(list);
        }
        for(int i=1;i<=flag.length;i++)
        {
            if(flag[i-1]==0&&(list.size()==0||Math.abs(i-list.get(list.size()-1))>1))
            {
                list.add(i);
                flag[i-1]=1;
                search(flag,list);
                list.remove(list.size()-1);
                flag[i-1]=0;
            }
        }
    }

}
