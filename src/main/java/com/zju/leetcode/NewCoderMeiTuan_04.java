package com.zju.leetcode;

public class NewCoderMeiTuan_04 {
    public static void main(String[] args) {
        int[] A={281,179,386,165,88,500};
        int n=6;
        System.out.println(new NewCoderMeiTuan_04().countArea2(A,n));
    }
    public int countArea(int[] A, int n) {
        // write code here
        int left=0;
        int right=n-1;
        int max=0;
        while (left<right)
        {
            int cur=Math.min(A[left],A[right])*(right-left+1);
            if(cur>max)
            {
                max=cur;
            }
            if(A[left]<A[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max;
    }
    public int countArea2(int[] A,int n)
    {
        int left=0;
        int right=n-1;
        int max=0;
        for (int i = 0; i < n-1; i++) {
            int cur_min=A[i];
            for (int j = i+1; j < n; j++) {
                if(A[j]<cur_min)
                {
                    cur_min=A[j];
                }
                if(cur_min*(j-i+1)>max)
                {
                    max=cur_min*(j-i+1);
                }
            }
        }
        return max;
    }
}
