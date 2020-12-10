package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class NewCoderHuaweiJ17 {
    static char[] Co={'A','D','W','S'};
    static int[] x={-1,1,0,0};
    static int[] y={0,0,1,-1};
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            String str=sin.nextLine();
            String[] moves=str.split(";");
            int cor_x=0;
            int cor_y=0;
            for (String s : moves) {
                int[] temp=calculate_move(s);
                cor_x+=temp[0];
                cor_y+=temp[1];
            }
            System.out.println(cor_x+","+cor_y);
        }
    }
    public static int[] calculate_move(String s)
    {
        int[] corr=new int[2];
        if(s.length()<=1||s.length()>3)
        {
            return corr;
        }
        int i;
        boolean flag=false;
        for (i = 0; i < 4; i++) {
            if(Co[i]==s.charAt(0))
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return corr;
        }
        int nums=0;
        for (int j = 1; j < s.length(); j++) {
            if(!Character.isDigit(s.charAt(j)))
            {
                nums=-1;
                break;
            }
            nums=nums*10+(s.charAt(j)-'0');
        }
        if(nums==-1)
        {
            return corr;
        }
        corr[0]=x[i]*nums;
        corr[1]=y[i]*nums;
        return corr;
    }
}
