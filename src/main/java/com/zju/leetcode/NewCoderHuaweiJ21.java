package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ21 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int char_to_num[]={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        while (sin.hasNext())
        {
            String s=sin.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if(Character.isLowerCase(s.charAt(i)))
                {
                    System.out.print(char_to_num[s.charAt(i)-'a']);
                }
                else if(Character.isUpperCase(s.charAt(i)))
                {
                    System.out.print((char)((s.charAt(i)-'A'+1)%26+'a'));
                }
                else
                {
                    System.out.print(s.charAt(i));
                }
            }
            System.out.print('\n');
        }
    }
}
