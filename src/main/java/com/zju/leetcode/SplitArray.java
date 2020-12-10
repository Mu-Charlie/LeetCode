package com.zju.leetcode;

public class SplitArray {
    public static int splitArray(int[] nums, int m) {
        int dp[][]=new int[nums.length+1][m+1];
        int max_value=0;
        dp[0][0]=0;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0]=Integer.MAX_VALUE;
        }
        int sum[]=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i&& j<=m; j++) {
                int temp_min=Integer.MAX_VALUE;
                for (int k = j-1; k <= i-1; k++) {
                    if(Math.max(dp[k][j-1],sum[i]-sum[k])<temp_min)
                    {
                        temp_min=Math.max(dp[k][j-1],sum[i]-sum[k]);
                    }
                }
                dp[i][j]=temp_min;
            }
        }
        max_value=dp[nums.length][m];
        return max_value;
    }

    public static void main(String[] args) {
        int nums[]={7,2,5,10,8};
        int m=2;
        System.out.println(splitArray(nums,m));
    }
}
