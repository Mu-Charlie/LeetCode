package com.zju.leetcode;

import java.util.*;

public class AccountMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> email2index=new HashMap<>();
        HashMap<String,String> email2name=new HashMap<>();
        int emailCount=0;
        for (List<String> account : accounts) {
            String name=account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email=account.get(i);
                if(!email2index.containsKey(email))
                {
                    email2index.put(email,emailCount++);
                    email2name.put(email,name);
                }
            }
        }
        UnionFind uf=new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String first_email=account.get(1);
            int index1=email2index.get(first_email);
            for (int i = 2; i < account.size(); i++) {
                String next_email=account.get(i);
                int index2=email2index.get(next_email);
                uf.union(index1,index2);
            }
        }
        Map<Integer,List<String>> index2Emails=new HashMap<>();
        for (String s : email2index.keySet()) {
            int root=uf.find(email2index.get(s));
            List<String> list=index2Emails.getOrDefault(root,new LinkedList<>());
            list.add(s);
            index2Emails.put(root,list);
        }
        List<List<String>> ans=new LinkedList<>();
        for (Integer index : index2Emails.keySet()) {
            List<String> list=index2Emails.get(index);
            Collections.sort(list);
            String name=email2name.get(list.get(0));
            List<String> account=new LinkedList<>();
            account.add(name);
            account.addAll(list);
            ans.add(account);
        }
        return ans;
    }

//    public static void main(String[] args) {
//        List<List<String>> accounts=new LinkedList<>();
//        String[][] strings={{"John", "johnsmith@mail.com", "john00@mail.com"},{"John", "johnnybravo@mail.com"},
//                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},{"Mary", "mary@mail.com"}};
//        for (String[] string : strings) {
//            List<String> list=new LinkedList<>();
//            for (String s : string) {
//                list.add(s);
//            }
//            accounts.add(list);
//        }
//        List<List<String>> lists = new AccountMerge_721().accountsMerge(accounts);
//        for (List<String> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//    }
}
class UnionFind{
    int parent[];
    public UnionFind(int n)
    {
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }
    public int find(int index)
    {
        if(parent[index]!=index)
        {
            parent[index]=find(parent[index]);
        }
        return parent[index];
    }
    public void union(int index1,int index2)
    {
        parent[find(index2)]=find(index1);
    }
}
