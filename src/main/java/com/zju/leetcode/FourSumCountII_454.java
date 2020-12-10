package com.zju.leetcode;

import java.util.HashMap;

public class FourSumCountII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> counts=new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                counts.put(-(A[i]+B[j]),counts.getOrDefault(-(A[i]+B[j]),0)+1);
            }
        }
        int result=0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                result+=counts.getOrDefault(C[i]+D[j],0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={1, 2};
        int[] B={-2,-1};
        int[] C={-1, 2};
        int[] D={ 0, 2};
        System.out.println(new FourSumCountII_454().fourSumCount(A, B, C, D));
    }
}
