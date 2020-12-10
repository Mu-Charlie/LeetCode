package com.zju.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinRange {
    public static void update_sorted_insert(LinkedList<Integer> list,LinkedList<Integer> index_list,Integer value,Integer index)
    {
        int size=list.size();
        int k=-1;
        for (int i = 0; i < index_list.size(); i++) {
            if(index_list.get(i)==index)
            {
                k=i;
                break;
            }
        }
        if(k!=-1)
        {
            list.remove(k);
            index_list.remove(k);
        }
        int i;
        for (i = 0; i < index_list.size(); i++) {
            if(list.get(i)>value)
            {
                break;
            }
        }
        list.add(i,value);
        index_list.add(i,index);
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] result=new int[2];
        result[0]=0;
        result[1]=200000;
        int total_num=0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                total_num+=1;
            }
        }
        MyNode[] mylist=new MyNode[total_num];
        int k=0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                mylist[k++]=new MyNode(nums.get(i).get(j),i);
            }
        }
        Arrays.sort(mylist);

        LinkedList<Integer> list_value=new LinkedList<Integer>();
        LinkedList<Integer> list_index=new LinkedList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            update_sorted_insert(list_value,list_index,nums.get(i).get(0),i);
        }

        int min_length=list_value.getLast()-list_value.getFirst();
        result[0]=list_value.getFirst();
        result[1]=list_value.getLast();

//        int first;
//        for ( first = 0; first < mylist.length; first++) {
//            if(mylist[first].value>list_value.getLast())
//            {
//                break;
//            }
//        }

        for (int i = 0; i < mylist.length; i++) {
            update_sorted_insert(list_value,list_index,mylist[i].value,mylist[i].classes);
            if(list_value.getLast()-list_value.getFirst()<min_length)
            {
                result[0]=list_value.getFirst();
                result[1]=list_value.getLast();
                min_length=result[1]-result[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums=new LinkedList<List<Integer>>();
        int[] a1={-5,-4,-3,-2,-1};
        int[] a2={1,2,3,4,5};
//        int[] a3={5,18,22,30};
        LinkedList<Integer> list=new LinkedList<Integer>();
        for (int i = 0; i < a1.length; i++) {
            list.add(a1[i]);
        }
        nums.add(list);
        LinkedList<Integer> list2=new LinkedList<Integer>();
        for (int i = 0; i < a2.length; i++) {
            list2.add(a2[i]);
        }
        nums.add(list2);
//        LinkedList<Integer> list3=new LinkedList<Integer>();
//        for (int i = 0; i < a3.length; i++) {
//            list3.add(a3[i]);
//        }
//        nums.add(list3);
        int[] result=smallestRange(nums);
        System.out.println(result[0]+","+result[1]);
    }
}
class MyNode implements Comparable<MyNode>{
    int value;
    int classes;
    public MyNode(int value,int classes)
    {
        this.classes=classes;
        this.value=value;
    }

    public int compareTo(MyNode o) {
        if(this.value>o.value)
        {
            return 1;
        }
        else if(this.value<o.value)
        {
            return -1;
        }
        return 0;
    }
}
