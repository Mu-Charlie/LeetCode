package com.zju.leetcode;

import java.util.Arrays;

public class NumRangeWithAnd_201 {

    public int rangeBitwiseAnd(int m, int n) {
        int bits[]=new int[32];
        Arrays.fill(bits,1);
        for (int i = m; i <= n; i++) {
            int flag=1;
            for (int j = 0; j < 32; j++,flag=flag<<1) {
                if(bits[j]==0||(i&flag)!=0)
                    continue;
                bits[j]=0;
            }
        }
        int result=0;
        for (int i = 0; i < 32; i++) {
            result=result*2+bits[31-i];
        }
        return result;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int bits[]=new int[32];
        Arrays.fill(bits,1);
        int last_start=0;//记录下最高几位
        int last_end=0;
        int f=1;
        for (int i = 0; i < 31; i++) {
            if((n&f)!=0)
                last_end=i;
            if((m&f)!=0)
                last_start=i;
            f=f<<1;
        }
        int start=0;
        if(last_end-last_start>=1)
        {
            start=last_end;
        }
        f=1;
        for (int i = 0; i < start; i++) {
            f=f<<1;
        }
        int total=32;
        for (int i = m; i <= n; i++) {
            int flag=f;
            for (int j = start; j < 32; j++,flag=flag<<1) {
                if(bits[j]==0||(i&flag)!=0)
                    continue;
                bits[j]=0;
                total--;
            }
            if(total<=0)
                break;
        }
        int result=0;
        for (int i = 0; i < 32; i++) {
            result=result*2+bits[31-i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumRangeWithAnd_201().rangeBitwiseAnd2(600000000,2147483645));
//        System.out.println(5&2);
    }
}
