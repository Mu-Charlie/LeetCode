package com.zju.leetcode;

public class NewCoderMethod {
    long M=10000000033l;
    public long solve (int a, int b, int n) {
        // write code here
        long fenzi=(quick_pow(n,b+1)-quick_pow(n,a)+M)%M;
        long fenmu=quick_pow(n-1,M-2);
        return quick_multi(fenzi,fenmu);
    }
    public long quick_pow(long a,long b)
    {
        long res=1;
        a=a%M;
        while (b>0)
        {
            if((b&1)==1)
            {
                res=quick_multi(res,a);
            }
            a=quick_multi(a,a);
            b=b>>1;
        }
        return res;
    }
    public long quick_multi(long a,long b)
    {
        a=a%M;
        b=b%M;
        long res=0;
        while (b>0)
        {
            if((b&1)==1)
            {
                res=(res+a)%M;
            }
            a=(a+a)%M;
            b=b>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NewCoderMethod().solve(100000000,1000000000,2));
    }
}
