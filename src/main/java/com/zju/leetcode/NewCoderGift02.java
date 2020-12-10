package com.zju.leetcode;

public class NewCoderGift02 {
    public static int selectPresent (int[][] presentVolumn) {
        if(presentVolumn.length==0)
        {
            return 0;
        }
        int[][] dp=new int[presentVolumn.length][presentVolumn[0].length];
        dp[0][0]=presentVolumn[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=dp[i-1][0]+presentVolumn[i][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i]=dp[0][i-1]+presentVolumn[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int min=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                dp[i][j]=min+presentVolumn[i][j];
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] nums={{1,2,3},{2,3,4}};
        System.out.println(selectPresent(nums));
    }
}
