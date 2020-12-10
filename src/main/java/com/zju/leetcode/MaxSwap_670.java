package com.zju.leetcode;

public class MaxSwap_670 {
    public int maximumSwap(int num) {
        int suffix[]=new int[9];//后缀最大值
        int nums[]=new int[9];
        int last[]=new int[10];
        int length=0;
        int lastMax=0;
        int max=num;
        while (num>0)
        {
            int cur=num%10;
            nums[8-length]=cur;
            num/=10;
            if(cur>lastMax)
            {
                lastMax=cur;

            }
            suffix[8-length]=lastMax;
            length++;
        }
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0||j>0)
            {
                last[nums[i]]=j++;
            }
        }
        for (int i = 0; i < length-1; i++) {
            if(nums[9-length+i]<suffix[9-length+i+1])
            {
                if(last[suffix[9-length+i+1]]>i)
                {
                    max=toInt(nums,i,last[suffix[9-length+i+1]]);
                    break;
                }
            }
        }
        return max;
    }
    public int toInt(int[] nums,int l,int r)
    {
        int result=0;
        int start=0;
        while (nums[start]==0)
            start++;
        for (int i = 0; i < nums.length; i++) {
            int cur;
            if(i==start+l)
            {
                cur=nums[start+r];
            }
            else if(i==start+r)
            {
                cur=nums[start+l];
            }
            else
            {
                cur=nums[i];
            }
            result=result*10+cur;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSwap_670().maximumSwap(123989));
    }
}
