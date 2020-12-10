package com.zju.leetcode;

import java.util.Scanner;

public class PDD_2020_1 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int T=sin.nextInt();
        for (int i = 0; i < T; i++) {
            int n=sin.nextInt();
            System.out.println((int)(Math.log(n)/Math.log(2))+1);
        }
    }
}
