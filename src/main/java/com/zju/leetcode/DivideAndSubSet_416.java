package com.zju.leetcode;

import java.util.Arrays;

public class DivideAndSubSet_416 {
    public boolean canPartition(int[] nums) {
        if(nums.length<2)
        {
            return false;
        }
        int total=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
            max=Math.max(max,nums[i]);
        }
        if(total/2<max)
        {
            return false;
        }
        if(total%2==0)//总和为奇数的话必然不可能分割
        {
            total=total/2;
            boolean[][]dp=new boolean[nums.length][total+1];
            for (int i = 0; i < nums.length; i++) {
                dp[i][0]=true;
            }
            dp[0][nums[0]]=true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j < total+1; j++) {
                    if(j>nums[i])
                    {
                        dp[i][j]=dp[i-1][j]|dp[i-1][j-nums[i]];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            return dp[nums.length-1][total];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(new DivideAndSubSet_416().canPartition(nums));
    }
}
