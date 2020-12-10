package com.zju.leetcode;

import java.util.LinkedList;

public class NewCoderTyping {
    public String Typing (String s) {
        // write code here
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='<')
            {
                if(sb.length()>0)
                {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new NewCoderTyping().Typing("ack<"));
    }
}
