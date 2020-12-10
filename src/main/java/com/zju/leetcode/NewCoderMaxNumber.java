package com.zju.leetcode;

public class NewCoderMaxNumber {
    public int solve (String s) {
        // write code here\
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        int max_num=0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))||s.charAt(i)>='a'&&s.charAt(i)<='f')
            {
                sb.append(s.charAt(i));
            }
            else
            {
                if(sb.length()>0)
                {
                    max_num=Math.max(max_num,Integer.valueOf(sb.toString(),16));
                    sb=new StringBuilder();
                }
            }
        }
        return max_num;
    }

    public static void main(String[] args) {
        NewCoderMaxNumber newCoderMaxNumber = new NewCoderMaxNumber();
        System.out.println(newCoderMaxNumber.solve("012345BZ16"));
    }
}
