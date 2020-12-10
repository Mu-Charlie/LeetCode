package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class NewCoderHuaweiJ16 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        int m=sin.nextInt();
        int[] v=new int[m+1];//价格
        int[] p=new int[m+1];//重要度
        int[] q=new int[m+1];//主件/附件
        for (int i = 1; i <= m; i++) {
            v[i]=sin.nextInt();
            p[i]=sin.nextInt();
            q[i]=sin.nextInt();
        }
        int[][] dp=new int[m+1][n+1];//总钱数也除以10
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if(q[i]==0)//主件
                {
                    if(j>=v[i])
                    {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+v[i]*p[i]);
                    }
                }
                else //附件
                {
                    if(j>=v[i]+v[q[i]])
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]-v[q[i]]]+v[i]*p[i]+v[q[i]]*p[q[i]]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(dp[m][n]);
    }
}
