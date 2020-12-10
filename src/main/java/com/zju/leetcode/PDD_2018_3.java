package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class PDD_2018_3 {
    public static void main(String[] args) {
        int n,m;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        int h[]=new int[n];
        for (int i = 0; i < n; i++) {
            h[i]=sin.nextInt();
        }
        Arrays.sort(h);
        int[] flag=new int[n];
        Arrays.fill(flag,0);
        m=sin.nextInt();
//        int w[]=new int[m];
        int counts=0;
        for (int i = 0; i < m; i++) {
            int w=sin.nextInt();
            for (int j = n-1; j >=0; j--) {
                if(flag[j]!=1)
                {
                    if(h[j]<=w)
                    {
                        flag[j]=1;
                        counts++;
                        break;
                    }
                }
            }
        }
        System.out.println(counts);
    }
}
