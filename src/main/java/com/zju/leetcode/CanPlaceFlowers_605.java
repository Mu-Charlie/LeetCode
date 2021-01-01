package com.zju.leetcode;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last=0;
        int index=0;
        while (index<flowerbed.length&&n>0)
        {
            int next=index==flowerbed.length-1? 0:flowerbed[index+1];
            if(last==0&&next==0&&flowerbed[index]==0)
            {
                --n;
                if(index+1==flowerbed.length)
                {
                    break;
                }
                else
                {
                    last=flowerbed[index+1];
                    index+=2;
                }
            }
            else
            {
                last=flowerbed[index];
                index++;
            }
        }
        return n==0;
    }

    public static void main(String[] args) {
        int[] flowered={1};
        int n=3;
        System.out.println(new CanPlaceFlowers_605().canPlaceFlowers(flowered, n));
    }
}
