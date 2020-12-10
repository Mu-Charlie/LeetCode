package com.zju.leetcode;

import java.util.HashSet;

public class JewelsInStones_771 {
    public int numJewelsInStones(String J, String S) {
        int result=0;
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i)))
            {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String J="z";
        String S="ZZZzzavg";
        System.out.println(new JewelsInStones_771().numJewelsInStones(J, S));
    }
}
