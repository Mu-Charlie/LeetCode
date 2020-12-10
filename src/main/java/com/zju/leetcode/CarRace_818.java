package com.zju.leetcode;

import java.util.Arrays;

public class CarRace_818 {
    public static int racecar(int target) {
        int step=0;
        int dis[]=new int[15];
        if(target==1)
        {
            return 1;
        }
        for (int i = 1; i < 15; i++) {
            dis[i]= (int) (Math.pow(2,i)-1);
        }
        while(target!=0)
        {
            int k= (int) Math.ceil(Math.log(target)/Math.log(2));
            int left,right;
            if(dis[k]<=target)
            {
                left=k;
            }
            else{
                left=k-1;
            }
            right=left+1;
//            int move=target-dis[left]<dis[right]-target ? left:right;
            if(target-dis[left]<dis[right]-target)
            {
                step+=left;
                target-=dis[left];
                if(target!=0)
                {
                    step+=2;
                }
            }
            else
            {
                step+=right;
                target=dis[right]-target;
                if(target!=0)
                {
                    step+=1;
                }
            }
        }
        return step;
    }

    public static int racecar2(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1; dp[2] = 4;

        for (int t = 3; t <= target; ++t) {
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1<<k) - 1) {
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k-1; ++j)
                dp[t] = Math.min(dp[t], dp[t - (1<<(k-1)) + (1<<j)] + k-1 + j + 2);
            if ((1<<k) - 1 - t < t)
                dp[t] = Math.min(dp[t], dp[(1<<k) - 1 - t] + k + 1);
        }

        return dp[target];
    }

    public static int racecar3(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1;i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int forword = 1;(1 << forword) - 1 < 2 * i; forword++) {
                int j = (1 << forword) - 1;
                if(j == i)
                    dp[i] = forword;
                else if (j > i)
                    dp[i] = Math.min(dp[i], forword + 1 + dp[j - i]);
                else
                    for(int back = 0; back < forword; back++) {
                        int k = (1 << back) - 1;
                        dp[i] =Math.min(dp[i], forword + 1 + back + 1 + dp[i - j + k]);
                    }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int counts=0;
        for (int i = 1; i < 10001; i++) {
//            System.out.print(i+":");
//            System.out.println(racecar2(i)+" "+racecar(i)+" "+racecar3(i));
            if(Math.abs(racecar2(i)-racecar(i))<0.00001)
            {
                counts++;
            }
        }
        System.out.println(1-(counts/10000.0));
    }
}
