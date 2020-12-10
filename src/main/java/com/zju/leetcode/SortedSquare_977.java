package com.zju.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class SortedSquare_977 {
    public int[] sortedSquares(int[] A) {
        int[] result=new int[A.length];
        int start=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]<0)
                start=i;
        }
        int end=start+1;
        int index=0;
        while (start>=0&&end<A.length)
        {
            if(Math.abs(A[start])<Math.abs(A[end]))
            {
                result[index]=A[start]*A[start];
                start--;
            }
            else if(Math.abs(A[start])>Math.abs(A[end]))
            {
                result[index]=A[end]*A[end];
                end++;
            }
            else
            {
                result[index]=result[index+1]=A[end]*A[end];
                index++;
                start--;
                end++;
            }
            index++;
        }
        while (start>=0)
        {
            result[index]=A[start]*A[start];
            start--;
            index++;
        }
        while (end<A.length)
        {
            result[index]=A[end]*A[end];
            end++;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={-5,-4,-3,-2,-1,0,1,2,3,4,5};
        System.out.println(Arrays.toString(new SortedSquare_977().sortedSquares(A)));
    }
}
