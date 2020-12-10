package com.zju.leetcode;

public class CalcuBinaSubString_696 {
    public int countBinarySubstrings(String s) {
        int nums[]=new int[2];
        int result=0;
        int flag=0;
        for (int i = 0; i < s.length(); i++) {
            int now=s.charAt(i);
            int counts=1;
            while (i+1<s.length()&&s.charAt(i+1)==now)
            {
                i++;
                counts++;
            }
            nums[flag%2]=counts;
            result+=(Math.min(nums[0],nums[1]));
            flag++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CalcuBinaSubString_696().countBinarySubstrings(""));
    }
}
