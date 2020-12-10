package com.zju.leetcode;

import java.util.Arrays;

public class SortedByParityII_922 {
    public int[] sortArrayByParityII(int[] A) {
        int target1=0,target2=1;
        while (target1<A.length&&target2<A.length)
        {
            while (target1<A.length&&A[target1]%2==0)
                target1+=2;
            while (target2<A.length&&A[target2]%2==1)
                target2+=2;
            if(target1<A.length&&target2<A.length)
            {
                int temp=A[target1];
                A[target1]=A[target2];
                A[target2]=temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int A[]={4,2,5,7};
        System.out.println(Arrays.toString(new SortedByParityII_922().sortArrayByParityII(A)));
    }
}
