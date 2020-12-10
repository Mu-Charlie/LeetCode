package com.zju.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NewCoderHuaweiJ14 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        String[] strings=new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=sin.next();
        }
        Arrays.sort(strings,new StringComaprator());
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
class StringComaprator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        int i;
        for (i = 0; i < Math.min(o1.length(),o2.length()); i++) {
            char c1=o1.charAt(i);
            char c2=o2.charAt(i);
            if(c1>c2)
            {
                return 1;
            }
            else if(c1==c2)
            {
                continue;
            }
            else
            {
                return -1;
            }
        }
        if(i<o1.length())
        {
            return 1;
        }
        else if(i<o2.length())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }



}
