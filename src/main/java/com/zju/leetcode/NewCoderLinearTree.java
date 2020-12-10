package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderLinearTree {
    public static int[] wwork (int T, int[] a) {
        // write code here
        int[] result=new int[T];
        for (int i = 0; i < T; i++) {
            int n=a[i];
            int index=1;

            while (n>1)
            {
                int l=(int)Math.ceil((double)n/2);
                int r=n-l;
                int left_height=(int)Math.ceil(Math.log(l)/Math.log(2))+1;
                int right_height=(int)Math.ceil(Math.log(r)/Math.log(2))+1;
                if(left_height>right_height)
                {
                    n=l;
                    index=index*2;
                }
                else
                {
                    index=index*2+1;
                    n=r;
                }
            }
            result[i]=index;
        }
        return result;
    }

    public static void main(String[] args) {
        int T=10;
        int[] a={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(wwork(T,a)));
    }
}
