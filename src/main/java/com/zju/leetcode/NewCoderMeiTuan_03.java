package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderMeiTuan_03 {
    public static void main(String[] args) {
        int [][]map={{0,1,0},{2,0,0}};
        int n=2;
        int m=3;
        System.out.println(new NewCoderMeiTuan_03().countPath(map,n,m));
    }
    public int countPath(int[][] map, int n, int m) {
        // write code
        int start_x=0,start_y=0,des_x=0,des_y=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==1)
                {
                    start_x=i;
                    start_y=j;
                }
                else if(map[i][j]==2)
                {
                    des_x=i;
                    des_y=j;
                }
            }
        }
        int[][]dp=new int[n][m];
        dp[start_x][start_y]=1;
        //分成四个部分 起点的左上 右上 右下 左下
        //与起点同行或者同列的都为1
        for (int i = 0; i < m; i++) {
            dp[start_x][i]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][start_y]=1;
        }
        //处理起点的左上部分
        for (int i = start_x-1; i >=0 ; i--) {
            for (int j = start_y-1; j >=0 ; j--) {
                if(map[i][j]==-1)
                {
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i][j+1]+dp[i+1][j];
            }
        }
        //处理起点的右上部分
        for (int i = start_x-1; i >=0 ; i--) {
            for (int j = start_y+1; j <m ; j++) {
                if(map[i][j]==-1)
                {
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i][j-1]+dp[i+1][j];
            }
        }

        //处理起点的右下部分
        for (int i = start_x+1; i < n ; i++) {
            for (int j = start_y+1; j < m; j++) {
                if(map[i][j]==-1)
                {
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }

        //处理起点的左下部分
        for (int i = start_x+1; i < n ; i++) {
            for (int j = start_y-1; j >=0; j--) {
                if(map[i][j]==-1)
                {
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i][j+1]+dp[i-1][j];
            }
        }
        return dp[des_x][des_y];
    }
}
