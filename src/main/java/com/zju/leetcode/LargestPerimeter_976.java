package com.zju.leetcode;

import java.util.Arrays;

public class LargestPerimeter_976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int[] edges={A[A.length-1],A[A.length-2]};
        int max_index=0;
        for (int i = 3; i <= A.length; i++) {
            if(edges[0]+edges[1]>A[A.length-i]&&edges[0]+A[A.length-i]>edges[1]&&edges[1]+A[A.length-i]>edges[0])
            {
                return edges[0]+edges[1]+A[A.length-i];
            }
            edges[max_index%2]=A[A.length-i];
            max_index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A={3,6,2,3};
        System.out.println(new LargestPerimeter_976().largestPerimeter(A));
    }
}
