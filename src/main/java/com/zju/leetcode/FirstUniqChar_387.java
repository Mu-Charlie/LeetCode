package com.zju.leetcode;

import java.util.Arrays;

public class FirstUniqChar_387 {
    public int firstUniqChar(String s) {
        int result=s.length();
        int[] flag=new int[26];
        Arrays.fill(flag,-1);
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(flag[c-'a']>=0)
            {
                flag[c-'a']=-2;
            }
            else if(flag[c-'a']==-1)
            {
                flag[c-'a']=i;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(flag[i]>=0&&flag[i]<result)
            {
                result=flag[i];
            }
        }
        if(result==s.length())
        {
            result=-1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s="dddccdbb";
        System.out.println(new FirstUniqChar_387().firstUniqChar(s));
    }
}
