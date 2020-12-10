package com.zju.leetcode;

public class LeaveCollector_LCP19 {
    public int minimumOperations(String leaves) {
        int[][] dp=new int[leaves.length()][3];
        dp[0][0]=leaves.charAt(0)=='y'? 1:0;
        dp[0][1]=dp[0][2]=dp[1][2]=Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            int r=leaves.charAt(i)=='r'? 1:0;
            int y=1-r;
            dp[i][0]=dp[i-1][0]+y;
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+r;
            if(i>=2)
            {
                dp[i][2]=Math.min(dp[i-1][1],dp[i-1][2])+y;
            }
        }
        return dp[leaves.length()-1][2];
    }
}
