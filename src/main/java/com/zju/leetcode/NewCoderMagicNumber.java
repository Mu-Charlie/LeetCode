package com.zju.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class NewCoderMagicNumber {
    public static String change (String number) {
        // write code here
        StringBuilder sb=new StringBuilder(number);
        int l=0,r=sb.length()-1;
        while (l<r)
        {
            while((sb.charAt(l)-'0')%2!=0) l++;
            while((sb.charAt(r)-'0')%2!=0) r--;
            if(l>=r)
            {
                break;
            }
            char temp=sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(change("1113319793989753447137982852365812943714215696313931897195341421591937983181336972514111432488981395"));
    }
}
