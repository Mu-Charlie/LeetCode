package com.zju.leetcode;

import java.util.Arrays;

public class Rotation_48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={{1}};
        new Rotation_48().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}