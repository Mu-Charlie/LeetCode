package com.zju.leetcode;

import javafx.util.Pair;

import java.nio.file.LinkPermission;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorgnizeString_767 {
    public String reorganizeString2(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

    public String reorganizeString(String S) {
        int[] chars=new int[26];
        Arrays.fill(chars,0);
        PriorityQueue<Pair<Character,Integer>> queue=new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int max=0;
        for (int i = 0; i < S.length(); i++) {
            chars[S.charAt(i)-'a']+=1;
            if(chars[S.charAt(i)-'a']>max)
            {
                max=chars[S.charAt(i)-'a'];
            }
        }
        if(max>(S.length()+1)/2)
        {
            return "";
        }
        else
        {
            char[] result=new char[S.length()];
            Arrays.fill(result,'X');
            for (int i = 0; i < 26; i++) {
                if(chars[i]!=0)
                {
                    queue.add(new Pair<Character, Integer>((char)(i+'a'),chars[i]));
                }
            }
            int n= queue.size();
            int ji_index=1,ou_index=0;
            for (int i = 0; i <n; i++) {
                Pair<Character, Integer> p = queue.poll();
                int num=p.getValue();
                while (ou_index<S.length()&&num>0)
                {
                    result[ou_index]=p.getKey();
                    ou_index+=2;
                    num--;
                }
                while (ji_index<S.length()&&num>0)
                {
                    result[ji_index]=p.getKey();
                    ji_index+=2;
                    num--;
                }
            }
            return new String(result);
        }
    }

    public static void main(String[] args) {
        String S="tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
//        String S="aab";
        System.out.println(new ReorgnizeString_767().reorganizeString(S));
    }
}
