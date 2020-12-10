package com.zju.leetcode;

public class IncreasingArray {
    public long IncreasingArray (int[] array) {
        // write code here
        long time=0;
        for (int i = 1; i < array.length; i++) {
            if(array[i-1]-array[i]>=0)
            {
                time+=array[i-1]-array[i]+1;
            }
        }
        return time;
    }
    public static void main(String[] args) {

    }
}
