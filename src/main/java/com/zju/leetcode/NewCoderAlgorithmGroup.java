package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderAlgorithmGroup {
    public static int[] solve (int n, int[] a, int[] p, int[] k) {
        // write code here
        int[] result=new int[n];
        Arrays.fill(result,0);
        for (int i = 0; i < n; i++) {
            if(k[i]>a[0])
            {
                continue;
            }
            if(k[i]==a[0])
            {
                result[0]++;
                continue;
            }
            int cur_solver=i;
            while (true)
            {
                if(a[cur_solver]>=k[i])
                {
                    result[cur_solver]++;
                    break;
                }
                cur_solver=p[cur_solver-1]-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n=4;
        int[] a={4,3,2,1};
        int[] p={1,2,3};
        int[] k={1,2,3,4};
        int[] result=solve(n,a,p,k);
        System.out.println(Arrays.toString(result));
    }
}
