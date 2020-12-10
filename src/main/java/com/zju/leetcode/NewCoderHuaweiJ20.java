package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ20 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            String s=sin.next();
            int counts=0;
            boolean flags[]=new boolean[4];
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                {
                    if(flags[0]==false)
                    {
                        counts++;
                        flags[0]=true;
                    }
                }
                else if(s.charAt(i)>='a'&&s.charAt(i)<='z')
                {
                    if(flags[1]==false)
                    {
                        counts++;
                        flags[1]=true;
                    }
                }
                else if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
                {
                    if(flags[2]==false)
                    {
                        counts++;
                        flags[2]=true;
                    }
                }
                else {
                    if(flags[3]==false)
                    {
                        counts++;
                        flags[3]=true;
                    }
                }
            }

            if(counts>=3&&!has_duplicate(s)&&s.length()>=8)
            {
                System.out.println("OK");
            }
            else
            {
                System.out.println("NG");
            }
        }
    }
    public static boolean has_duplicate(String s)
    {
        for (int i = 0; i < s.length() - 2; i++) {
            String sub_s=s.substring(i,i+3);
            if(s.substring(i+1).contains(sub_s))
            {
                return true;
            }
        }
        return false;
    }
}
