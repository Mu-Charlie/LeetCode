package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class NewCoderDIDI_02 {
    public static void main(String[] args) {
        int n,m;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        m=sin.nextInt();
        int[] tables=new int[n];
        for (int i = 0; i < n; i++) {
            tables[i]=sin.nextInt();
        }
        Pair[] customers=new Pair[m];
        for (int i = 0; i < m; i++) {
            customers[i]=new Pair(sin.nextInt(),sin.nextInt());
        }
        boolean[] flag=new boolean[n];
        int j=0;
        Arrays.sort(tables);
        Arrays.sort(customers);
        long income=0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if(tables[k]>=customers[i].c&&flag[k]==false)
                {
                    income+=customers[i].v;
                    flag[k]=true;
                    break;
                }
            }
        }
        System.out.println(income);
    }
}
class Pair implements Comparable<Pair> {
    int c;
    int v;
    public Pair(int c,int v)
    {
        this.c=c;
        this.v=v;
    }

    @Override
    public int compareTo(Pair o) {
        if(v>o.v)
        {
            return -1;
        }
        else if(v<o.v)
        {
            return 1;
        }
        else
        {
            return o.c-c;
        }
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", v=" + v +
                '}';
    }
}
