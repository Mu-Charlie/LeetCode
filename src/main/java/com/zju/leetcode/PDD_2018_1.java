package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class PDD_2018_1 {
    public static void replace_min(int[] nums,int target,int flag)
    {//flag取值为 1或-1
        //循环找到最小到的 替换
        int min=nums[0]*flag;
        int index=0;
        for ( int j = 0; j < 3; j++) {
            if(nums[j]*flag<min)
            {
                min=nums[j]*flag;
                index=j;
            }
        }
        if(target*flag>min)
        {
            nums[index]=target;
        }
    }
//    public static void main(String[] args) {
//        Scanner sin =new Scanner(System.in);
//        int n;
//        int max;
//        n=sin.nextInt();
//        int nums[]=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]=sin.nextInt();
//        }
//        int positive_num=0;
//        int min_nagtive=0;
//        int max_nagtive=0;
//        int nagitve_num=0;
//        Integer p_max_num[]=new Integer[3];
//        Integer n_min_num[]=new Integer[3];
//        Integer n_max_num[]=new Integer[3];
//        for (int i = 0; i < n; i++) {
//            if(nums[i]>=0)//正数
//            {
//                if(positive_num<3)//正数的个数还不足3个
//                {
//                    p_max_num[positive_num]=nums[i];
//                }
//                else{//正数的个数已经大于等于3个
//                    //循环找到最小到的 替换
//                    replace_min(p_max_num,nums[i],1);
//                }
//                positive_num++;
//            }
//            else if(nums[i]<0)//负数
//            {
//                //找出最大的负数
//                if(max_nagtive<3)
//                {
//                    n_max_num[max_nagtive]=nums[i];
//                    max_nagtive++;
//                }
//                else{
//                    replace_min(n_max_num,nums[i],1);
//                }
//
//                //找出最小的负数
//                if(min_nagtive<3)
//                {
//                    n_min_num[min_nagtive]=nums[i];
//                    min_nagtive++;
//                }
//                else{
//                    replace_min(n_min_num,nums[i],-1);
//                }
//
//                nagitve_num++;
//            }
//
//        }
//        if(nagitve_num==0)
//        {
//            max=p_max_num[0]*p_max_num[1]*p_max_num[2];
//        }
//        else if(positive_num==0)
//        {
//            max=n_max_num[0]+n_max_num[1]+n_max_num[2];
//        }
//        else
//        {
//            if(nagitve_num<2)
//            {
//                max=p_max_num[0]*p_max_num[1]*p_max_num[2];
//            }
//            else
//            {
//                int max_p_count=positive_num>3 ? 3:positive_num;
//
//                if(positive_num<=2)
//                {
//
//                }
//                else
//                {
//
//                }
//            }
//        }
//
////        int positive_num=0;
////        int min_nagtive=0;
////        int max_nagtive=0;
////        int nagitve_num=0;
////        boolean zero=false;
////        Integer p_max_num[]=new Integer[3];
////        Integer n_min_num[]=new Integer[3];
////        Integer n_max_num[]=new Integer[3];
//        System.out.println("正数个数："+positive_num);
//        System.out.println(Arrays.toString(p_max_num));
//        System.out.println("============================");
//        System.out.println("最大负数个数："+max_nagtive);
//        System.out.println(Arrays.toString(n_max_num));
//        System.out.println("============================");
//        System.out.println("最小负数个数："+min_nagtive);
//        System.out.println(Arrays.toString(n_min_num));
//        System.out.println("============================");
//        System.out.println("所有负数个数："+nagitve_num);
//        System.out.println("============================");
//        System.out.println("零："+zero);
//    }
    public static void main(String[] args) {
        Scanner sin =new Scanner(System.in);
        int n;
        int max_value;
        n=sin.nextInt();
        int max[]=new int[3];
        int min[]=new int[3];
        for (int i = 0; i < n; i++) {

            if(i<2)
            {
                min[i]=max[i]=sin.nextInt();
            }
            else if(i==2)
            {
                int target=sin.nextInt();
                max[i]=target;
                replace_min(min,target,-1);
            }
            else
            {
                int target=sin.nextInt();
                replace_min(max,target,1);
                replace_min(min,target,-1);
            }
        }
        int max_num=Math.max(max[0],Math.max(max[1],max[2]));
        max_value=Math.max(max[0]*max[1]*max[2],max_num*(min[0]*min[1]));
        System.out.println(max_value);
//        System.out.println((-1000)*(-1000)*(-1000));

    }
}
