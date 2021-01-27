package com.zju.leetcode;

public class NumEquivDominoPairs_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] flags=new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            flags[dominoes[i][0]][dominoes[i][1]]+=1;
        }
        int ans=0;
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int nums=flags[i][j];
                if(i!=j)
                {
                    nums+=flags[j][i];
                }
                ans+=(nums*(nums-1))/2;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] dominoes={{1,2},{1,2},{1,2},{2,1},{3,4},{3,4}};
        System.out.println(new NumEquivDominoPairs_1128().numEquivDominoPairs(dominoes));
    }
}
