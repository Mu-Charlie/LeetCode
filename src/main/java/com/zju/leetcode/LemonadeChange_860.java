package com.zju.leetcode;

public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        int five_left=0,ten_left=0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5)
            {
                five_left+=1;
            }
            else if(bills[i]==10)
            {
                five_left-=1;
                ten_left+=1;
            }
            else
            {
                five_left-=1;
                if(ten_left>0)
                {
                    ten_left-=1;
                }
                else
                {
                    five_left-=2;
                }
            }
            if(five_left<0||ten_left<0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills={5,5,10,10,20};
        System.out.println(new LemonadeChange_860().lemonadeChange(bills));
    }
}
