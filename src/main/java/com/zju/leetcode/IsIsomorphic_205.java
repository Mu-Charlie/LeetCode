package com.zju.leetcode;

import java.util.HashMap;

public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashMap<Character,Character> remap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if((map.containsKey(c1)&&map.get(c1)!=c2)||(remap.containsKey(c2)&&remap.get(c2)!=c1))
            {
                return false;
            }
            map.put(c1,c2);
            remap.put(c2,c1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s="paper";
        String t="title";
        System.out.println(new IsIsomorphic_205().isIsomorphic(s, t));
    }
}
