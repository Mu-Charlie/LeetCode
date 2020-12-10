package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NewCoderMagicCircle {
    public int[] solve2 (int n, int m, int[] l, int[] r, int[] k) {
        // write code here
        LinkedList<Integer> s=new LinkedList<>();
        int f[]=new int[n];
        Arrays.fill(f,0);
        for (int i = 0; i < m; i++) {
            f[k[i]-1]++;
        }
        for (int i = 0; i < n; i++) {
            if(f[i]%2!=0)
            {
                s.add(i+1);
            }
        }
        for (int i = 0; i < s.size(); i++) {
            int center=s.get(i);
            LinkedList<Integer> stack=new LinkedList<>();
            stack.addFirst(center);
            while (!stack.isEmpty())
            {
                int cur_center=stack.removeFirst();
                int temp=l[cur_center-1];
                l[cur_center-1]=r[cur_center-1];
                r[cur_center-1]=temp;
                if(r[cur_center-1]!=0)
                {
                    stack.addFirst(r[cur_center-1]);
                }
                if(l[cur_center-1]!=0)
                {
                    stack.addFirst(l[cur_center-1]);
                }
            }
        }
        int visited[]=new int[n];
        Arrays.fill(visited,0);
        LinkedList<Integer> stack=new LinkedList<>();
        stack.add(1);
        int result[]=new int[n];
        int num=0;
        while (!stack.isEmpty())
        {
            int cur=stack.getFirst();
            if(visited[cur-1]==0)
            {
                visited[cur-1]=1;
                if(l[cur-1]!=0)
                {
                    stack.addFirst(l[cur-1]);
                }
            }
            else if(visited[cur-1]==1)
            {
                visited[cur-1]=2;
                result[num++]=cur;
                stack.removeFirst();
                if(r[cur-1]!=0)
                {
                    stack.addFirst(r[cur-1]);
                }
            }
        }
        return result;
    }
    //直接统计之后将为奇数的记为1 之后再利用hashmap来判断是否仍然需要做旋转这个思路存在问题，即可能有多个节点存在相同的子节点，这个思路只能解决存在两个节点相交的情况，存在多个就会发生错误。
    //比如假设4既是3的子节点，也是2的子节点，如果4,2,3都需要旋转。假设顺序为3,4,2，这时，判断3时，发现4在旋转列表中，因此不对4进行旋转，并将4标记为已旋转，这时并没有问题，当判断到2时，2也发现4在列表中，这时也会跳过它。
    //考虑修改，多加一个判断，如果已经被处理了，就仍然需要旋转，不跳过
    public int[] solve (int n, int m, int[] l, int[] r, int[] k) {
        // write code here
        //旋转
        int visited[]=new int[n];
        Arrays.fill(visited,0);
        for (int i = 0; i < m; i++) {
            visited[k[i]-1]++;
        }
        HashMap<Integer,Boolean> flags=new HashMap<Integer, Boolean>();
        for (int i = 0; i < n; i++) {
            if(visited[i]%2!=0)
            {
                flags.put(i+1,false);
            }
        }
        for (Integer center : flags.keySet()) {
            if(flags.get(center))
            {
                continue;
            }
            LinkedList<Integer> stack=new LinkedList<>();
            stack.addFirst(center);
            while (!stack.isEmpty())
            {
                int cur_center=stack.removeFirst();
                int temp=l[cur_center-1];
                l[cur_center-1]=r[cur_center-1];
                r[cur_center-1]=temp;
                if(r[cur_center-1]!=0)
                {
                    if(flags.containsKey(r[cur_center-1])&&!flags.get(r[cur_center-1]))
                    {
                        flags.put(r[cur_center-1],true);
                    }
                    else{
                        stack.addFirst(r[cur_center-1]);
                    }
                }
                if(l[cur_center-1]!=0)
                {
                    if(flags.containsKey(l[cur_center-1])&&!flags.get(l[cur_center-1]))
                    {
                        flags.put(l[cur_center-1],true);
                    }
                    else{
                        stack.addFirst(l[cur_center-1]);
                    }
                }
            }
        }

        Arrays.fill(visited,0);
        LinkedList<Integer> stack=new LinkedList<>();
        stack.add(1);
        int result[]=new int[n];
        int num=0;
        while (!stack.isEmpty())
        {
            int cur=stack.getFirst();
            if(visited[cur-1]==0)
            {
                visited[cur-1]=1;
                if(l[cur-1]!=0)
                {
                    stack.addFirst(l[cur-1]);
                }
            }
            else if(visited[cur-1]==1)
            {
                visited[cur-1]=2;
                result[num++]=cur;
                stack.removeFirst();
                if(r[cur-1]!=0)
                {
                    stack.addFirst(r[cur-1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NewCoderMagicCircle test=new NewCoderMagicCircle();
        int n=44;
        int m=44;
        int l[]={2,5,7,22,28,10,8,20,19,31,16,0,0,21,26,0,41,39,37,0,29,30,32,0,0,0,0,0,0,38,0,36,0,0,0,0,0,0,42,0,0,0,0,0};
        int r[]={3,4,14,6,18,40,9,11,13,33,12,0,15,17,0,0,0,0,25,24,0,23,43,44,0,27,0,34,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int k[]={15,23,1,42,43,16,6,4,43,42,34,1,37,33,14,30,39,15,20,5,9,36,44,11,8,42,36,16,18,26,44,42,17,14,43,27,8,17,13,26,8,32,5,33};
        System.out.println(Arrays.toString(test.solve(n,m,l,r,k)));
//        28,34,5,18,42,39,2,31,35,10,33,6,40,4,32,36,23,43,22,38,30,1,16,11,12,8,20,24,44,7,13,26,27,15,9,25,19,37,3,29,21,14,41,17
//        28,34,5,18,39,42,2,31,35,10,33,6,40,4,32,36,23,43,22,38,30,1,16,11,12,8,20,24,44,7,13,26,27,15,9,25,19,37,3,29,21,14,41,17
    }
}
