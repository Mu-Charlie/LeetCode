package com.zju.leetcode;

import java.util.Arrays;

public class SortString_1370 {
    public String sortString(String s) {
        int[] counts=new int[26];
        Arrays.fill(counts,0);
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']+=1;
        }
        StringBuilder sb=new StringBuilder();
        int total_num=s.length();
        while (total_num>0)
        {
            for (int i = 0; i < 26; i++) {
                if(counts[i]>0)
                {
                    sb.append((char)('a'+i));
                    counts[i]-=1;
                    total_num--;
                }
            }
            if(total_num==0)
            {
                break;
            }
            for (int i = 25; i >=0 ; i--) {
                if(counts[i]>0)
                {
                    sb.append((char)('a'+i));
                    counts[i]-=1;
                    total_num--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="ggggggg";
        System.out.println(new SortString_1370().sortString(s));
    }
}
