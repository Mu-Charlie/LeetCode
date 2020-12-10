package com.zju.leetcode.multiThread;

import java.util.concurrent.TimeUnit;

public class testThread {
    private volatile boolean a=true;
    public static void main(String[] args) {
        testThread demo1=new testThread();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (demo1.a){
                    i++;
                }
                System.out.println(i);
            }
        });
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo1.a=false;
        System.out.println("被设置为false");
    }
}
