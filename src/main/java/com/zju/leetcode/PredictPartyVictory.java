package com.zju.leetcode;

import java.util.Arrays;

public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        int Rnum=0,Dnum=0;
        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i)=='R')
            {
                Rnum+=1;
            }
            else
            {
                Dnum+=1;
            }
        }
        boolean flag[]=new boolean[senate.length()];
        Arrays.fill(flag,true);
        while (Rnum>0&&Dnum>0)
        {
            for (int i = 0; i < senate.length(); i++) {
                if(flag[i])
                {
                    if(senate.charAt(i)=='R')
                    {
                        //寻找下一个D
                        int temp=i+1;
                        while (senate.charAt(temp%senate.length())!='D'||!flag[temp%senate.length()])
                        {
                            temp++;
                        }
                        //将下一个D失效
                        flag[temp%senate.length()]=false;
                        //更新D的数目
                        Dnum--;
                    }
                    else
                    {
                        //寻找下一个R
                        int temp=i+1;
                        while (senate.charAt(temp%senate.length())!='R'||!flag[temp%senate.length()])
                        {
                            temp++;
                        }
                        //将下一个D失效
                        flag[temp%senate.length()]=false;
                        //更新D的数目
                        Rnum--;
                    }
                }
                if(Rnum<=0||Dnum<=0)
                {
                    break;
                }
            }
        }
        if(Dnum<=0)
        {
            return "Radiant";
        }
        else
        {
            return "Dire";
        }
    }

    public static void main(String[] args) {
        System.out.println(new PredictPartyVictory().predictPartyVictory("D"));
    }
}
