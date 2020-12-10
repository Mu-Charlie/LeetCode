package com.zju.leetcode;

import java.util.HashMap;

public class NewCoderBoard {
    public int solve (int n, int m, int[] a) {
        // write code here
        HashMap<Integer,Integer> firstmet=new HashMap<>();
        firstmet.put(0,-1);
        int black_num=0;
        int max_value=0;
        for (int i = 0; i < n; i++) {
            if(a[i]==0)
            {
                black_num++;
                firstmet.put(black_num,i);
            }

            max_value=Math.max(max_value,i-firstmet.getOrDefault(black_num-m,0));
        }
        return max_value;
    }
}
