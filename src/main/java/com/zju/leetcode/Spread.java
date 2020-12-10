package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Spread {
    public int[] solve (int n, int m, int[] u, int[] v, int[] q) {
        // write code here
        LinkedList<Integer>[] map=new LinkedList[n+1];
        for (int i = 0; i <= n; i++) {
            map[i]=new LinkedList<>();
        }
        for (int i = 0; i < u.length; i++) {
            map[u[i]].add(v[i]);
            map[v[i]].add(u[i]);
        }
        int[] result=new int[n+1];
        Arrays.fill(result,0);
        for (int i : q) {
            result[i]++;
        }
        int[] counts=new int[n];
        for (int i = 0; i < n; i++) {
            counts[i]+=result[i+1];
            for (Integer next : map[i + 1]) {
                counts[next-1]+=result[i+1];
            }
        }
        return counts;
    }
    public int[] solve2 (int n, int m, int[] u, int[] v, int[] q) {
        // write code here
        LinkedList<Integer>[] map=new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i]=new LinkedList<>();
        }
        for (int i = 0; i < u.length; i++) {
            map[u[i]].add(v[i]);
            map[v[i]].add(u[i]);
        }
        int[] result=new int[n];
        for (int i = 0; i < m; i++) {
            int cur_index=q[i];
            result[cur_index-1]++;
            for (Integer next : map[q[i]]) {
                result[next-1]++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Spread spread = new Spread();
        int n=200000;
        int m=200000;
        int[] u=new int[199999];
        int[] v=new int[199999];
        int[] q=new int[200000];
        Arrays.fill(u,1);
        for (int i = 0; i < 199999; i++) {
            v[i]=i+2;
        }
        for (int i = 0; i < 200000; i++) {
            q[i]=i+1;
        }
        System.out.println(Arrays.toString(spread.solve2(n,m,u,v,q)));
    }
}
