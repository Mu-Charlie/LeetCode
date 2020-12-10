package com.zju.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ReCoverIP_93 {
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> result=new LinkedList<>();
        finded_ip(s,0,1,result,new StringBuilder());
        return result;
    }
    public void finded_ip(String s,int start,int layer,List<String> list,StringBuilder temp_result)
    {
        if(s.length()-start<=(5-layer)*3&&s.length()-start>=5-layer)
        {
            if(layer==4)//ip的最后一个
            {
                int temp=to_int(s,start,s.length()-1);
                if(temp>255)
                {
                    return;
                }
                temp_result.append(s.substring(start));
                list.add(temp_result.toString());
            }
            else
            {
                if(s.length()-start-1<=(4-layer)*3&&s.length()-start-1>=4-layer)//本次数字长度为1
                {
                    StringBuilder sb=new StringBuilder(temp_result);
                    finded_ip(s,start+1,layer+1,list,sb.append(s.substring(start,start+1)+"."));
                }
                if(s.charAt(start)!='0'&&s.length()-start-2<=(4-layer)*3&&s.length()-start-2>=4-layer)//数字长度为2
                {
                    StringBuilder sb=new StringBuilder(temp_result);
                    finded_ip(s,start+2,layer+1,list,sb.append(s.substring(start,start+2)+"."));
                }
                if(s.charAt(start)!='0'&&s.length()-start-3<=(4-layer)*3&&s.length()-start-3>=4-layer)//数字长度为3
                {
                    if(to_int(s,start,start+2)<=255)//判断是否超过255
                    {
                        StringBuilder sb=new StringBuilder(temp_result);
                        finded_ip(s,start+3,layer+1,list,sb.append(s.substring(start,start+3)+"."));
                    }
                }
            }
        }

    }
    public int to_int(String s,int start,int end)
    {
        int res=0;
        for (int i = start; i <= end; i++) {
            res=res*10+(s.charAt(i)-'0');
        }
        if(res<10&&end-start>0||res<100&&end-start>1)
        {
            return 256;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReCoverIP_93().restoreIpAddresses("010010"));
    }
}
