package com.zju.leetcode;

public class LongestMoutains_845 {
    public int longestMountain(int[] A) {
        if(A.length<3)
        {
            return 0;
        }
        int length=0;
        boolean flag=true;//false代表先寻找下降的位置
        int result=0;
        for (int i = 1; i < A.length; i++) {
            if(flag)
            {
                if(length==0&&A[i]<A[i-1]||A[i]==A[i-1])
                {
                    length=0;
                }
                else if(A[i]>A[i-1])
                {
                    length++;
                }
                else
                {
                    flag=false;
                    length++;
                    i--;
                }
            }
            else
            {
                if(A[i]>=A[i-1]||i==A.length-1)
                {
                    if(i==A.length-1&&A[i]<A[i-1])
                    {
                        length++;
                    }
                    result=Math.max(result,length);
                    flag=true;
                    i--;
                    length=0;
                }
                else
                {
                    length++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num[]={2,1,4,7,3,2,5};
        System.out.println(new LongestMoutains_845().longestMountain(num));
    }
}
