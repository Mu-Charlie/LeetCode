package com.zju.leetcode;

public class NewCoderChangeRoad {
    public int solve (int n, int[] a1, int[] a2, int[] a3, int[] m) {
        // write code here
        int dp[][]=new int[3][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=a1[i];
            dp[1][i]=a2[i];
            dp[2][i]=a3[i];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i]+=Math.max(dp[0][i-1],dp[1][i-1]-m[i-1]);
            dp[1][i]+=Math.max(dp[0][i-1]-m[i-1],Math.max(dp[1][i-1],dp[2][i-1]-m[i-1]));
            dp[2][i]+=Math.max(dp[1][i-1]-m[i-1],dp[2][i-1]);
        }
        return Math.max(dp[0][n-1],Math.max(dp[1][n-1],dp[2][n-1]));
    }

    public static void main(String[] args) {
        int n=3;
        int a1[]={1,9,3};
        int a2[]={6,4,6};
        int a3[]={1,1,5};
        int m[]={3,2,1};
        System.out.println(new NewCoderChangeRoad().solve(n,a1,a2,a3,m));
    }
}
