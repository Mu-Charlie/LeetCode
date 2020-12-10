package com.zju.leetcode;

public class StingMuilti_43 {
    public String multiply(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < num2.length(); i++) {
            int cur_n2=num2.charAt(num2.length()-1-i)-'0';
            int upper=0;
            for (int j = 0; j < num1.length(); j++) {
                if(i+j>=sb.length())
                {
                    sb.append(0);
                }
                int cur_n1=num1.charAt(num1.length()-1-j)-'0';
                int cur_sum=sb.charAt(i+j)-'0';
                int temp_plus=cur_n1*cur_n2+upper+cur_sum;
                int cur_add=temp_plus%10;
                upper=temp_plus/10;
                sb.setCharAt(i+j,(char)(cur_add+'0'));
            }
            if(upper!=0)
            {
                sb.append((char)(upper+'0'));
            }
        }
        int start=0;
        for (start= 0; start < sb.length(); start++) {
            if(sb.charAt(sb.length()-1-start)!='0')
            {
                break;
            }
        }
        if(sb.length()==start)
        {
            return "0";
        }
        return sb.reverse().substring(start);
    }

    public static void main(String[] args) {
        System.out.println(new StingMuilti_43().multiply("123", "0"));
    }
}
