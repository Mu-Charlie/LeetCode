package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuawei03 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            String str=sin.next();
            int start;
            if(str.charAt(0)!='0'||str.charAt(1)!='x')
            {
                start=0;
            }
            else
            {
                start=2;
            }
            int nums=0;
            for (int i = start; i < str.length(); i++) {
                char c=str.charAt(i);
                if(Character.isDigit(c))
                {
                    nums=nums*16+(c-'0');
                }
                else if(Character.isUpperCase(c))
                {
                    nums=nums*16+(c-'A'+10);
                }
                else if(Character.isLowerCase(c))
                {
                    nums=nums*16+(c-'a'+10);
                }
            }
            StringBuilder sb=new StringBuilder();
            while (nums>0)
            {
                sb.append(nums%10);
                nums/=10;
            }
            System.out.println(sb.reverse());
        }
    }
}
