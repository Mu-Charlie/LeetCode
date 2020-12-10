package com.zju.leetcode;

import java.util.*;

public class OneZeroMatrix_542 {
    static int[] row={0,-1,0,1};
    static int[] col={-1,0,1,0};
    public static int[][] updateMatrix(int[][] matrix) {
        int [][] result=new int[matrix.length][matrix[0].length];
//        Vector<int[]> corr_queue=new Vector<int[]>();
        LinkedList<int[]> corr_queue=new LinkedList<int[]>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==1)
                {
                    result[i][j]=-1;
                }
                else
                {
                    result[i][j]=0;
                    corr_queue.addFirst(new int[]{i,j});
                }
            }
        }
        while(!corr_queue.isEmpty())
        {
            int []cor=corr_queue.getLast();
            corr_queue.removeLast();
            for (int i = 0; i < 4; i++) {
                int new_x=cor[0]+row[i];
                int new_y=cor[1]+col[i];
                if(new_x>=0&&new_x<matrix.length&&new_y>=0&&new_y<matrix[0].length&&result[new_x][new_y]==-1)
                {
                    result[new_x][new_y]=result[cor[0]][cor[1]]+1;
                    corr_queue.addFirst(new int[]{new_x,new_y});
                }
            }
        }
        return result;
    }
//    public static void bfs(int[][] matrix,int[][] result,int n)
//    {
//
//    }

    public static void main(String[] args) {
        int[][] matix={{0,0,0},{0,1,0},{1,1,1}};
        int[][] result=updateMatrix(matix);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
