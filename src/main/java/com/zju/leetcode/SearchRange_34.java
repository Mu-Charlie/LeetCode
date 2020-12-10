package com.zju.leetcode;

import java.util.Arrays;

public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int result[]=new int[2];
        result[0]=result[1]=-1;
//        if(nums[l]==target)
//        {
//            result[0]=l;
//        }
//        if(nums[r]==target)
//        {
//            result[1]=r;
//        }
        if(result[0]==-1)
        {
            result[0]=find_left_bound(nums,target);
        }
        if(result[0]!=-1&&result[1]==-1)
        {
            result[1]=find_right_bound(nums,target);
        }
        return result;
    }
    public int find_left_bound(int[] nums, int target)
    {
        if(nums.length==0)
        {
            return -1;
        }
        int l=0,r=nums.length-1;
        while (l<r)
        {
            int mid=(l+r)/2;
            if(nums[mid]>=target)
            {
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        if(nums[l]==target)
        {
            return l;
        }
        else if(l+1<nums.length&&nums[l+1]==target)
        {
            return l+1;
        }
        return -1;
    }
    public int find_right_bound(int[] nums, int target)
    {
        if(nums.length==0)
        {
            return -1;
        }
        int l=0,r=nums.length-1;
        while (l<r)
        {
            int mid=(l+r)/2;
            if(nums[mid]>target)
            {
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        if(nums[r]==target)
        {
            return r;
        }
        else if(r-1>=0&&nums[r-1]==target)
        {
            return r-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={};
        int target=9;
        System.out.println(Arrays.toString(new SearchRange_34().searchRange(nums, target)));
    }
}
