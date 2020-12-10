package com.zju.leetcode;

public class NewCoderGift {
    public static int selectPresent (int[][] presentVolumn) {
        // write code here
        if(presentVolumn.length==0)
        {
            return 0;
        }
        int[][] dp=new int[presentVolumn.length+1][presentVolumn[0].length+1];
        for (int i = 0; i <= presentVolumn.length; i++) {
            dp[i][0]=Integer.MAX_VALUE;
        }
        for (int i = 0; i <= presentVolumn[0].length; i++) {
            dp[0][i]=Integer.MAX_VALUE;
        }
        dp[0][0]=0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int up=dp[i-1][j];
                int left=dp[i][j-1];
                int left_up=dp[i-1][j-1];
                dp[i][j]=Math.min(up,Math.min(left,left_up))+presentVolumn[i-1][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] nums={{1,2,3},{2,3,4}};
        System.out.println(selectPresent(nums));
    }
}
