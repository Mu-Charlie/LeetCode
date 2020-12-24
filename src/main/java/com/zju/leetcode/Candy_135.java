package com.zju.leetcode;

public class Candy_135 {
    public int candy(int[] ratings) {
        int pre=1;
        int result=1;
        int lastInc=1,curDec=0;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>=ratings[i-1])
            {
                curDec=0;
                pre=ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                result+=pre;
                lastInc=pre;
            }
            else
            {
                curDec++;
                if(curDec==lastInc)
                {
                    curDec++;
                }
                result+=curDec;
                pre=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings={1,2,2};
        System.out.println(new Candy_135().candy(ratings));
    }
}
