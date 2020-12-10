package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderMatchesPuzzle {
    public long[] MaxArea (int n, int[] Stick) {
        // write code here
        int[] statics=new int[100001];
        int max_length=0;
        for (int i : Stick) {
            max_length=Math.max(max_length,i);
            statics[i]++;
        }
        long result[]=new long[2];
        for (int i = max_length; i >0; i--) {
            int cur_num=statics[i];
            if(cur_num==0)
                continue;
            result[1]+=(long)i*i*(cur_num/4);
            cur_num=cur_num%4;
            result[0]+=(long)i*i*(cur_num/3);
        }
        return result;
    }

    public static void main(String[] args) {
        int n=4;
        int Sticks[]={1,1,1,1};
        System.out.println(Arrays.toString(new NewCoderMatchesPuzzle().MaxArea(n,Sticks)));
    }
}
