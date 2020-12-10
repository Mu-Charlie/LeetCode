package com.zju.leetcode;

import java.util.HashMap;

public class NewCoderSuperMarket {
    public int solve (int n, int x, int[][] a) {
        // write code here
        int dp[][]=new int[n+1][x+1];
        dp[0][0]=1;
        for (int i = 1; i <= n; i++) {
            int money=a[i-1][0];
            for (int j = 0; j <= x; j++) {
                for (int k = 0; k <= a[i - 1][1]; k++) {
                    if(j-k*money>=0)
                    {
                        dp[i][j]+=dp[i-1][j-k*money];
                    }
                    else
                        break;
                }
            }
        }
        return dp[n][x];
    }

    public static void main(String[] args) {
        int n=2;
        int x=10;
        int[][] a={{1,5},{2,4}};
        System.out.println(new NewCoderSuperMarket().solve(n,x,a));
    }
}
