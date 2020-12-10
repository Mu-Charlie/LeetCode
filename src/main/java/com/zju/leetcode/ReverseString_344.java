package com.zju.leetcode;

import java.util.Arrays;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        if(s.length==0)
        {
            return;
        }
        char temp;
        for (int i = 0; i <= (s.length-1)/2; i++) {
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }

    public static void main(String[] args) {
        char[] s={};
        new ReverseString_344().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
