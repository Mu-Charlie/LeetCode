package com.zju.leetcode;

import java.util.Arrays;

public class PDDGrayCode {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PDDGrayCode().getGray(0)));
    }
    public String[] getGray(int n) {
        // write code here
        int num=1<<n;
        String[] result=new String[num];
        if(n==1)
        {
            result[0]="0";
            result[1]="1";
            return result;
        }
        String[] temp=getGray(n-1);
        for (int i = 0; i < num / 2; i++) {
            result[i]="0"+temp[i];
            result[num-1-i]="1"+temp[i];
        }
        return result;
    }
}
