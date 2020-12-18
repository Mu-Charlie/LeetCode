package com.zju.leetcode;

public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int[] map_a=new int[26];
        int[] map_b=new int[26];
        for (int i = 0; i < s.length(); i++) {
            map_a[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < t.length(); i++) {
            map_b[t.charAt(i)-'a']+=1;
        }
        int i = 0;
        for (; i < 26; i++) {
            if(map_a[i]!=map_b[i])
            {
                break;
            }
        }
        return (char)(i+'a');
    }

    public static void main(String[] args) {
        String s="ae";
        String t="aea";
        System.out.println(new FindTheDifference_389().findTheDifference(s, t));
    }
}
