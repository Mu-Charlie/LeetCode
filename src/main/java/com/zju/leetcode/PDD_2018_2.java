package com.zju.leetcode;

import javafx.beans.binding.StringBinding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PDD_2018_2 {
    public static void main(String[] args) {
        String str1,str2;
        Scanner sin=new Scanner(System.in);
        str1=sin.next();
        str2=sin.next();
        LinkedList<Integer> result=new LinkedList<Integer>();
        for (int i = 0; i < str1.length(); i++) {
            result.add(0);
        }

        for (int i = 0; i < str2.length(); i++) {
            int cur_num=str2.charAt(str2.length()-1-i)-'0';
            int up=0;
            for (int j = 0; j < str1.length(); j++) {
                int num2=str1.charAt(str1.length()-1-j)-'0';
                int sum;
                if(i+j<result.size())
                {
                    sum=num2*cur_num+result.get(i+j)+up;
                    up=sum/10;
//                    if(sum>=10)
//                    {
//                        up+=1;
//                    }
                    result.set(i+j,sum%10);
                }
                else
                {
                    sum=num2*cur_num+up;
                    up=sum/10;
                    result.add(sum%10);
                }
            }
            if(up>0)
            {
                result.add(up);
            }
//            System.out.println(Arrays.toString(result.toArray()));
        }
        for (int i = result.size()-1; i >=0 ; i--) {
            System.out.print(result.get(i));
        }

    }
}
