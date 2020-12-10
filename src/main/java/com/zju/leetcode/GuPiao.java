package com.zju.leetcode;
public class GuPiao {
    public static void main(String[] args) {
        int num[]={2,3,4,1,5,6,7};
        System.out.println(solve(num));
    }
    public static int solve(int[] num)
    {
        int max=0;//最大值
        if(num.length==0)
        {
            return 0;
        }
        int minValue=num[0];
        for (int i = 1; i < num.length; i++) {
            if(num[i]-minValue>max)//如果当前值间之前的最小值大于max
            {
                max=num[i]-minValue;//更新max
            }
            if(num[i]<minValue)//当前值小于之前最小值 更新最小值
            {
                minValue=num[i];
            }
        }
        return max;
    }
}
