package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderSimpleChangeRoad {
    public int solve (int n, int m, int[] x, int[] y) {
        // write code here
        int dp[][]=new int[3][n];
        for (int i = 0; i < x.length; i++) {
            dp[x[i]-1][y[i]-1]=-1;
        }
        dp[0][0]=1;
        dp[1][0]=dp[2][0]=0;
        for (int i = 1; i < n; i++) {
            dp[0][i]=dp[0][i]==-1? 0:(dp[0][i-1]+dp[1][i-1])%1000000007;
            dp[1][i]=dp[1][i]==-1? 0:(dp[0][i-1]+dp[1][i-1]+dp[2][i-1])%1000000007;
            dp[2][i]=dp[2][i]==-1? 0:(dp[1][i-1]+dp[2][i-1])%1000000007;
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        return dp[2][n-1];
    }

    public static void main(String[] args) {
        int n=350;
        int m=35;
        int a2[]={3,3,3,1,1,2,1,2,2,3,3,1,3,1,3,1,2,3,3,2,1,3,3,1,1,2,1,1,2,1,2,2,3,3,3};
        int a3[]={302,47,85,8,13,1,329,239,31,231,57,343,87,241,199,15,57,279,246,33,163,57,79,284,315,91,236,345,101,235,288,110,200,32,249};
        System.out.println(new NewCoderSimpleChangeRoad().solve(n,m,a2,a3));
    }
}
