package com.zju.leetcode;

import java.util.Arrays;

public class IsAngaram_283 {
    public boolean isAnagram(String s, String t) {
        int[] origin=new int[26];
        int[] target=new int[26];
        Arrays.fill(origin,0);
        Arrays.fill(target,0);
        if(s.length()!=t.length())
        {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            origin[s.charAt(i)-'a']+=1;
            target[t.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < 26; i++) {
            if(origin[i]!=target[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="cat";
        String t="rat";
        System.out.println(new IsAngaram_283().isAnagram(s, t));
    }
}
