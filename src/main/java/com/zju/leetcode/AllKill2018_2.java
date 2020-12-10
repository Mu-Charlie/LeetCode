package com.zju.leetcode;

import java.util.*;

public class AllKill2018_2 {
    public static void main(String[] args) {
        solution();
    }
    public static void solution()
    {
        int n,m;
        HashSet<Integer> set=new HashSet<Integer>();
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        m=sin.nextInt();

        for (int i = 0; i < n; i++) {
            int x;
            x=sin.nextInt();
            set.add(x);
        }
        for (int i = 0; i < m; i++) {
            int x;
            x=sin.nextInt();
            set.add(x);
        }


        List<Integer> set_list=new ArrayList<Integer>(set);
        Collections.sort(set_list);
        for (Integer integer : set_list) {
            System.out.printf(integer+" ");
        }
    }
}
