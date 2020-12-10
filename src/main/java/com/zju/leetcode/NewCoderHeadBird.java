package com.zju.leetcode;

import java.util.LinkedList;

public class NewCoderHeadBird {
    public long solve (int n, int[] a) {
        // write code here
        long counts=0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0; j--) {
                if(a[i]<a[j])
                {
                    counts+=j+1;
                    break;
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        int[]a={5,4,3,2,1};
        System.out.println(new NewCoderHeadBird().solve(5,a));
        System.out.println(101&1);
        System.out.println(null==null);
    }
}
