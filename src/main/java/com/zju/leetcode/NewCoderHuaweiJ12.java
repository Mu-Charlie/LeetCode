package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ12 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        String s=sin.nextLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(s.length()-1-i));
        }
    }
}
