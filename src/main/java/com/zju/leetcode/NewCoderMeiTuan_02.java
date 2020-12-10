package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderMeiTuan_02 {
    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        int[] move_x={0,-1,0,1};
        int[] move_y={-1,0,1,0};
        for (int i = 0; i < f.length; i++) {
            int x=f[i][0]-1,y=f[i][1]-1;
            for (int j = 0; j < 4; j++) {
                if(x+move_x[j]>=0&&x+move_x[j]<A.length&&y+move_y[j]>=0&&y+move_y[j]<A[0].length)
                {
                    A[x+move_x[j]][y+move_y[j]]^=1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A={{0,0,1,1}, {1,0,1,0}, {0,1,1,0}, {0,0,1,0}};
        int[][] f={{2,2},{3,3},{4,4}};
        int[][] ints = new NewCoderMeiTuan_02().flipChess(A, f);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
