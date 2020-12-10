package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Intersaction_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result=new HashSet<>();
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]))
            {
                result.add(nums2[i]);
            }
        }
        int[] interSet=new int[result.size()];
        int index=0;
        for (Integer integer : result) {
            interSet[index]=integer;
            index++;
        }
        return interSet;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={4,5,6};
        System.out.println(Arrays.toString(new Intersaction_349().intersection(nums1, nums2)));
    }
}
