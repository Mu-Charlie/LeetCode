package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrefixesDivBy5_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int mod=0;
        List<Boolean> ans=new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            mod=((mod<<1)+A[i])%5;
            ans.add(mod==0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A={1,1,1,0,1};
        System.out.println(Arrays.toString(new PrefixesDivBy5_1018().prefixesDivBy5(A).toArray()));
    }
}
