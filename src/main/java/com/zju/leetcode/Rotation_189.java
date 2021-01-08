package com.zju.leetcode;

import java.util.Arrays;

public class Rotation_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            int[] nums={1,2,3,4,5,6,7};
            new Rotation_189().rotate(nums,i);
            System.out.println(Arrays.toString(nums));
        }
    }
}
