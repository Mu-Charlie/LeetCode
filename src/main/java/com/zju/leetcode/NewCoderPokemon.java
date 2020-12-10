package com.zju.leetcode;

public class NewCoderPokemon {
    public static long Pokemonfight (long HP, long ACK, long HP2, long ACK2) {
        // write code here
        long Origin_HP=HP2;
        long counts=0;
        if(HP2>ACK&&ACK2>=HP)
        {
            return 1;
        }
        if(HP2<=2*ACK)
        {
            return -1;
        }
        //总共需要多少次攻击
        long total_time=(long)Math.ceil((double)HP/ACK2);
        //一轮 最多可以攻击多少次
        long max_attack=(long)Math.ceil((double)HP2/ACK)-2;
        //一轮 一般带来多少伤害
        if(max_attack>=total_time)
        {
            return total_time;
        }
        else
        {
            long left_time=(total_time-max_attack-1)/max_attack;
            if((total_time-max_attack-1)%max_attack!=0)
                left_time+=1;
            return total_time+left_time;
        }
    }

    public static void main(String[] args) {
        long HP=8;
        long ACK=3;
        long HP2=8;
        long ACK2=1;
//        System.out.println(Pokemonfight(HP,ACK,HP2,ACK2));
        System.out.println(2&(-2));
    }
}
