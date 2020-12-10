package com.zju.leetcode;

public class ValidMoutainArray_941 {
    public boolean validMountainArray(int[] A) {
        boolean result=true;
        boolean flag=true;
        for (int i = 1; i < A.length; i++) {
            if(flag)
            {
                if(A[i]<A[i-1])
                {
                    if(i==1)
                    {
                        return false;
                    }
                    flag=false;
                }
                else if(A[i]==A[i-1])
                {
                    result=false;
                    break;
                }
            }
            else
            {
                if(A[i]>=A[i-1])
                {
                    result=false;
                    break;
                }
            }
        }
        result=result&(!flag);
        return result;
    }

    public static void main(String[] args) {
        int[] nums={3,4,4,3,1};
        System.out.println(new ValidMoutainArray_941().validMountainArray(nums));
    }
}
