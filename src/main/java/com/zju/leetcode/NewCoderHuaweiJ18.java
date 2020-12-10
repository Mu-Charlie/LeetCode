package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ18 {

    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int[] counts=new int[7];
        while (sin.hasNext())
        {
            String ip_mask=sin.nextLine();
            String[] s = ip_mask.split("~");
            char ip_class=IP_Classes(s[0]);
            boolean legal_mask=another_correct_mask(s[1]);
            if(ip_class=='F'||!legal_mask)
            {
                counts[5]+=1;
            }
            else if(ip_class>='A'&&ip_class<='E')
            {
                counts[ip_class-'A']+=1;
                if(ip_class-'A'<=2&&isprivate(s[0]))//如果是A~E中的一种 再判断是否是私有
                {
                    counts[6]+=1;
                }
            }
        }
        System.out.println(counts[0]+" "+counts[1]+" "+counts[2]+" "+counts[3]+" "+counts[4]+" "+counts[5]+" "+counts[6]);
    }

    //判断是否是私有
    public static boolean isprivate(String s)
    {
        String[] ips = s.split("\\.");
        int first=to_int(ips[0]);
        int seconde=to_int(ips[1]);
        if(first==10||(first==172&&seconde>=16&&seconde<=31)||(first==192&&seconde==168))
        {
            return true;
        }
        return false;
    }
    //判断ABCDE类 以及不属于任何类（N） 及错误IP类（F）
    public static char IP_Classes(String ip)
    {
        String[] seg = ip.split("\\.");
        if(seg.length<4)
        {
            return 'F';
        }
        int[] num_ip=new int[4];
        for (int i=0;i<4;i++) {
            int temp=to_int(seg[i]);
            if(temp<0||temp>255)//非法ip值
            {
                return 'F';
            }
            num_ip[i]=temp;
        }
        if(num_ip[0]>=1&&num_ip[0]<=126)
        {
            return 'A';
        }
        else if(num_ip[0]>=128&&num_ip[0]<=191)
        {
            return 'B';
        }
        else if(num_ip[0]>=192&&num_ip[0]<=223)
        {
            return 'C';
        }
        else if(num_ip[0]>=224&&num_ip[0]<=239)
        {
            return 'D';
        }
        else if(num_ip[0]>=240&&num_ip[0]<=255)
        {
            return 'E';
        }
        else
        {
            return 'N';
        }
    }
    public static int to_int(String s)
    {
        if(s.length()==0)
        {
            return -1;
        }
        int nums=0;
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i)))
            {
                return -1;
            }
            nums=nums*10+(s.charAt(i)-'0');
        }
        return nums;
    }
//    public static boolean correct_mask(String mask)
//    {
//        int []correct_value={255,254,252,248,240,224,192,128,0};
//        String[] masks = mask.split("\\.");
//        if(masks.length<4)
//        {
//            return false;
//        }
//        int last=255;
//        for (int i = 0; i < 4; i++) {
//            int temp=to_int(masks[i]);
//            if(temp>last)//后面的掩码值应该小于等于前一个
//            {
//                return false;
//            }
//            boolean flag=false;
//            for (int i1 : correct_value) {//掩码值应该是那8个数字中的一个
//                if(i1==temp)
//                {
//                    flag=true;
//                    break;
//                }
//            }
//            if(!flag)//没有找到对应的掩码值
//            {
//                return false;
//            }
//            last=temp;
//        }
//        return true;
//    }
    public static boolean another_correct_mask(String mask)
    {
        String[] masks = mask.split("\\.");
        if(masks.length<4)
        {
            return false;
        }
        int bit_count=0;
        int flag=0;
        for (int i = 0; i < 4; i++) {
            int temp=to_int(masks[3-i]);
            if(temp<0||temp>255)
            {
                return false;
            }
            int a=1;
            for (int j = 0; j < 8; j++) {
                if((temp&a)==0)
                {
                    if(flag!=0)
                        return false;
                }
                else
                {
                    if(bit_count==0)
                    {
                        return false;
                    }
                    flag=1;
                }
                a=a<<1;
                bit_count++;
            }
        }
        return true;
    }
}

