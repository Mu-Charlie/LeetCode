package com.zju.leetcode;

public class NewCoderGroup {
    public int solve (int n, int k, int[] a) {
        // write code here
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        int left=0;
        int right=sum;
        while (left<right)
        {
            int mid=(left+right+1)/2;
            if(CorrectGroup(a,mid,k))
            {
                left=mid;
            }
            else
            {
                right=mid-1;
            }
        }
        return left;
    }
    public boolean CorrectGroup(int[] a,int max_min,int target)
    {
        int k=0;
        int size=0;
        for (int i = 0; i < a.length; i++) {
            size+=a[i];
            if(size>=max_min)
            {
                k++;
                size=0;
            }
            if(k>=target)
            {
                break;
            }
        }
        return k>=target;
    }

    public static void main(String[] args) {
        int n=4;
        int k=2;
        int a[]={1,2,1,5};
        System.out.println(new NewCoderGroup().solve(n,k,a));
    }
}
