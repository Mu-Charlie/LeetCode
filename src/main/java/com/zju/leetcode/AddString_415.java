package com.zju.leetcode;

public class AddString_415 {
    public static void main(String[] args) {
        String s1,s2;
        s1="123459";
        s2="5624312";
        System.out.println(addStrings(s1,s2));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int up=0;
        int i;
        for (i = 0; i < num1.length()&& i <num2.length(); i++) {
            int cur=(num1.charAt(num1.length()-1-i)-'0')+(num2.charAt(num2.length()-1-i)-'0')+up;
            sb.append(cur%10);
            up=cur/10;
        }
        System.out.println(i);
        System.out.println(sb);
        while (i<num1.length())
        {
            int cur=num1.charAt(num1.length()-1-i)-'0'+up;
            sb.append(cur%10);
            up=cur/10;
            i++;
        }

        while (i<num2.length())
        {
            int cur=num2.charAt(num2.length()-1-i)-'0'+up;
            sb.append(cur%10);
            up=cur/10;
            i++;
        }
        if(up>0)
        {
            sb.append(up);
        }
        return sb.reverse().toString();
    }
}
