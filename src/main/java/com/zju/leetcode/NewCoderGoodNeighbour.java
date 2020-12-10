package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderGoodNeighbour {
    public int[] solve (int n, int m, int[] a, int[] x) {
        // write code here
        int result[]=new int[m];
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            int l=0,r=a.length-1;
            long min_dis=Math.min(Math.abs(x[i]-a[l]),Math.abs(x[i]-a[r]));
            while (l<=r)
            {
                int mid=(l+r)/2;
                min_dis=Math.min(min_dis,Math.abs(x[i]-a[mid]));
                if(x[i]==a[mid])
                {
                    break;
                }
                else if(x[i]>a[mid])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
            result[i]=(int)min_dis;
        }
        return result;
    }

    public static void main(String[] args) {
        NewCoderGoodNeighbour gn=new NewCoderGoodNeighbour();
//        int n=3,m=2;
//        int a[]={2,4,7};
//        int x[]={5,8};
//        System.out.println(Arrays.toString(gn.solve(n,m,a,x)));
        System.out.println(Integer.MAX_VALUE);
    }
}
