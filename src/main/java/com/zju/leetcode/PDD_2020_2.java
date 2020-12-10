package com.zju.leetcode;

import java.util.Scanner;

public class PDD_2020_2 {
    public static void main(String[] args) {
        int T;
        Scanner sin=new Scanner(System.in);
        T=sin.nextInt();
        for (int i = 0; i < T; i++) {
            int n=sin.nextInt();
            if(n==1||n==2)
            {
                System.out.println(1+" "+1);
            }
            else if(n==3)
            {
                System.out.println(0+" "+2);
            }
            else{
                System.out.println(0+" "+n);
            }
        }
    }
}
