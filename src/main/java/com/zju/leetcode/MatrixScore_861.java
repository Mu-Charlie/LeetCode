package com.zju.leetcode;

public class MatrixScore_861 {
    public int matrixScore(int[][] A) {
        int result=0;
        for (int i = 0; i < A[0].length; i++) {
            int oneNum=0;
            for (int j = 0; j < A.length; j++) {
                if(A[j][0]==1)
                {
                    oneNum+=A[j][i];
                }
                else
                {
                    oneNum+=(1-A[j][i]);
                }
            }
            oneNum=Integer.max(oneNum,A.length-oneNum);
            result=result*2+oneNum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A={{0,1}};
        System.out.println(new MatrixScore_861().matrixScore(A));
    }
}
