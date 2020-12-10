package com.zju.leetcode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AllKill2018_3 {
    public static void solution(){
        int n;
        ArrayList<Integer> list=new ArrayList<Integer>();
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sin.nextInt());
        }
        double rate=0;
        int k= (int) Math.ceil(n*0.6);
        double dp[][]=new double[n+1][k];
        dp[0][0]=1;

        for(int i=1;i<=n;i++)
        {
            dp[i][0]=dp[i-1][0]*(100-list.get(i-1))/100;
            for(int j=1;j<=i&&j<k;j++)
            {
                dp[i][j]=dp[i-1][j]*(100-list.get(j-1))/100+dp[i-1][j-1]*list.get(j-1)/100;
            }
        }
        for(int i=0;i<k;i++)
        {
            rate+=dp[n][i];
        }
        rate=1-rate;
        NumberFormat nbf=new DecimalFormat("0.00000");
//        nbf.setMaximumFractionDigits(5);

        System.out.println(nbf.format(rate));
    }

    public static void main(String[] args) {
        solution();
    }
}
