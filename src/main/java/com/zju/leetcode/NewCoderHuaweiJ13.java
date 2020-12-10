package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ13 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        String s=sin.nextLine();
        int start=s.length()-1;
        int end=s.length()-1;
        StringBuilder sb=new StringBuilder();
        while (start>=0)
        {
            if(s.charAt(start)==' '||start==0)
            {
                if(start==0)
                    start=-1;
                sb.append(s.substring(start+1,end+1)+" ");
                end=start-1;
            }
            start--;
        }
        System.out.println(sb.toString());
    }
}
