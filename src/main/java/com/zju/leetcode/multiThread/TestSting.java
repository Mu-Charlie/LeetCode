package com.zju.leetcode.multiThread;

public class TestSting {
    public static void main(String[] args) {
        String a="abc";
        String b="abc";
        String c="a";
        String d=c+"bc";
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(a));
        System.out.println(d.hashCode());
        System.out.println(a==d);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
    }
}
