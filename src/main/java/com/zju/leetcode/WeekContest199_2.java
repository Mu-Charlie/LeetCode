package com.zju.leetcode;

public class WeekContest199_2 {
    public static int minFlips(String target) {
        int start=0;
        int count=0;
        char last='0';
        for (; start < target.length(); start++) {
            if (target.charAt(start) != 0)
                break;
        }
        for (int i = start; i < target.length(); i++) {
            if(target.charAt(i)==0)
                continue;
            if(last!=target.charAt(i))
            {
                count++;
                last=target.charAt(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String target="001011101";
        System.out.println(minFlips(target));
    }
}
