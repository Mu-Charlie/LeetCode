package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderManyNiuNiu {
    public int solve (String s) {
        // write code here
        String target="niuniu";
        int M=1000000007;
        int dp[][]=new int[7][s.length()+1];
        Arrays.fill(dp[0],1);
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if(s.charAt(j-1)==target.charAt(i-1))
                    dp[i][j]=(dp[i][j-1]%M+dp[i-1][j]%M)%M;
                else
                    dp[i][j]=dp[i][j-1];
            }
        }
        return dp[6][s.length()];
    }

    public static void main(String[] args) {
        NewCoderManyNiuNiu test=new NewCoderManyNiuNiu();
        System.out.println(test.solve("niuniniu"));
    }
}
