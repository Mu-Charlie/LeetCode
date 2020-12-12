package com.zju.leetcode;

public class WiggleMaxLength_376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1)
        {
            return nums.length;
        }
        int minusNums[]=new int[nums.length-1];
        int i=1;
        int flag=1;
        for ( ; i < nums.length; i++) {
            if(nums[i]-nums[i-1]>0)
            {
                flag=1;
                break;
            }
            else if(nums[i]-nums[i-1]<0)
            {
                flag=-1;
                break;
            }
        }
        int maxLength=0;
        for (; i < nums.length; i++) {
            if((nums[i]-nums[i-1])*flag>0)
            {
                maxLength++;
                flag*=-1;
            }
        }
        return maxLength+1;
    }

    public static void main(String[] args) {
        int nums[]={0,1};
        System.out.println(new WiggleMaxLength_376().wiggleMaxLength(nums));
    }
}
