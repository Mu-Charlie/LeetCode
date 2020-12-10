package com.zju.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class LongPressedName_925 {
    public boolean isLongPressedName(String name, String typed) {
        int start_name=0;
        boolean flag=true;
        for (int start_typed = 0; start_typed < typed.length(); start_typed++) {
            if(start_name<name.length()&&typed.charAt(start_typed)==name.charAt(start_name))
            {
                start_name++;
                continue;
            }
            else
            {
                if(start_name==0)
                {
                    flag=false;
                    break;
                }
                else if(name.charAt(start_name-1)==typed.charAt(start_typed))
                {
                    continue;
                }
                else
                {
                    flag=false;
                    break;
                }
            }
        }
        if(start_name<name.length())
        {
            flag=false;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName_925().isLongPressedName("laiden","laiden"));
    }
}
