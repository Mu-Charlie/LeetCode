package com.zju.leetcode;

public class MaxProfit_714 {
    public int maxProfit(int[] prices, int fee) {
        int maxprofit=0;
        int buy=prices[0]+fee;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]+fee<buy)
            {
                buy=prices[i]+fee;
            }
            else if(prices[i]>buy)
            {
                maxprofit+=prices[i]-buy;
                buy=prices[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices={1, 3, 2, 8, 4, 9};
        int fee=2;
        System.out.println(new MaxProfit_714().maxProfit(prices, fee));
    }
}
