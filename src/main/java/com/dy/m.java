package com.dy;

import com.dy.leetcode._链表相关.ListNode;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.List;

public class m {
    public static void main(String[] args) {
        Integer[] str = {
                8151775,
        8224631,
        8787409,
        8133500,
        8155404,
        811992,
        8127885,
        8585808,
        8239795,



        };
        Long[] pre = {
                81394934872l,
                81297990609l,
                82375709125l,
                85225685566l,
                81332071046l,
                81776040516l,
                81295144350l,
                89617509623l,
                85779408244l,
                81299798032l,
                82257513938l,
                81297988313l,
                85211563839l,
                895602341774l,
                85866540275l,
                87786690019l,
                895402830304l,
                81222789705l,
                81278797287l,
                81385583949l,
                82122775818l,
                82199908874l,
                81213680628l,
                81244959793l,
                81268412675l,
                81316163757l,
                81222207732l,
                81345020279l,
                81240964823l,
                81335004100l,
                81246929991l,
                81290437841l,
                81382055431l,
                81554047338l,
                82118050014l,
                82341182467l,
                81224385179l,
                85326975221l,
                82298472750l,
                82273105349l,
                81372250394l,
                8159617878l,
                81387836477l,
                82320193245l,
                82152103118l,
                81373504774l,
                82333937114l,
                81287209894l,
                81280155227l,
                81220007700l,
                82145793294l,
                85648600295l,
                81377891881l,
                81225872692l,
                81294108185l,
                82120684886l,
                85717888737l,
                81388239991l,
                81211770720l,
                82123222774l,
                81218431883l,
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
            String s1 = s.substring(0, 6);
            for (String p : pre) {
                if (s1.equals(p.substring(0, 6))) res.add(p);
            }
        }
        return res;
    }
}
