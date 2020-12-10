package com.zju.leetcode;

import java.util.Arrays;

public class IntegerBreak_343 {
    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static int integerBreak(int n) {
        int []dp=new int[n+1];
        dp[1]=dp[2]=1;
        for (int i = 2; i <=n ; i++) {
            int max_value=0;
            for (int j = 1; j <= i/2; j++) {
                int left=Math.max(dp[j],j);
                int right=Math.max(i-j,dp[i-j]);
                max_value=Math.max(left*right,max_value);
            }
            dp[i]=max_value;
        }
        return dp[n];
    }
    public static void maxBreak(int dp[],int n)
    {
        if(dp[n]!=-1)
        {
            return;
        }
        int left=n/2;
        maxBreak(dp,n/2);
        maxBreak(dp,n-n/2);
        dp[n]=Math.max(left,dp[left])*Math.max(n-n/2,dp[n-n/2]);
    }

    public static void main(String[] args) {
        for (int i = 2; i < 59; i++) {
            System.out.println(integerBreak(i)==integerBreak2(i));
        }
    }
}
