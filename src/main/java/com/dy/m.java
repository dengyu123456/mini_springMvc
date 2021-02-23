package com.dy;

import com.dy.leetcode._链表相关.ListNode;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.List;

public class m {
    public static void main(String[] args) {
        Integer[] str = {
                8131147,
        8131359,
        8161767,
        8122462,
        8131601,
        8147713,

        };
        Long[] pre = {
                8126010707l,
                89635943068l,
                85337104704l,
                85212716821l,
                85299669966l,
                87810234410l,
                81210797476l,
                895329383259l,
                85374586275l,
                87880360329l,
                81261295925l,
                895386507770l,
                89683765233l,
                82114671378l,
                81230960165l,
                85213531934l,
                82116370823l,
                8994992956l,
                82316550550l,
                82115811615l,
                89667208823l,
                81290126801l,
                8123578023l,
                81364187534l,
                82123753809l,
                82372109390l,
                87780160432l,
                85640879272l,
                89509718199l,
                89648651605l,
                81388107019l,
                85729824894l,
                81298647779l,
                82295400392l,
                81377596500l,
                85267703615l,
                81343099528l,
                85950581252l,
                85228159108l,
                81219107355l,
                85830799315l,
                85974657054l,
                81220800045l,
                81315330085l,
                85730610355l,
                81224824442l,
                85884795498l,
                81311207826l,
        };
        List<String> list = m1(str, pre);
        for(String s:list){
            System.out.println(s);
        }

    }

    public static List<String> m1(Integer[] strInt, Long[] pLong) {
        List<String> str = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        for (Integer i : strInt) {
            str.add(i.toString());
        }
        for (Long l : pLong) {
            pre.add(l.toString());
        }

        List<String> res = new ArrayList<>();
        for (String s : str) {
            String s1 = s.substring(0, 7);
            for (String p : pre) {
                if (s1.equals(p.substring(0, 7))) res.add(p);
            }
        }
        return res;
    }
}
