package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {


    public List parse(String str, int x){
        if (x == 1){
            JSONArray objects = JSON.parseArray(str);
            ArrayList<Integer> list = new ArrayList<>();
            for (Object obj :objects){
                list.add(Integer.parseInt(obj.toString()));
            }
            return list;
        }
        ArrayList objects = new ArrayList<>();
        JSONArray objects1 = JSON.parseArray(str);
        for (Object obj :  objects1){
            objects.add(parse(obj.toString(),x-1));
        }
        return objects;
    }

    public Object[] parseArray(String str, int x){
        List parse = parse(str, x);
        return parsing(parse,x);
    }

    public Object[] parsing(List li,int x){
        if (x == 1){
            return li.toArray();
        }
        Object[] objects2 = new Object[li.size()];
        for (int i = 0 ; i< objects2.length;i++){
            Object o = li.get(i);
            if (o instanceof List){
                objects2[i]=parsing((List) o,x-1);
            }
        }
        return objects2;
    }

    public int[] parsing1(String str){
        List parse = parse(str,1);
        int[] ints = new int[parse.size()];
        for(int i = 0 ; i <ints.length;i++){
            ints[i] =(int) parse.get(i);
        }
        return ints;
    }

    public int[][] parsing2(String str){
        List parse = parse(str,2);
        int[][] ints = new int[parse.size()][];
        for (int i = 0 ; i < ints.length;i++){
            if(parse.get(i) instanceof List){
                ints[i] = parsing1(parse.get(i).toString());
            }
        }
        return ints;
    }

    public int[][][] parsing3(String str){
        List parse = parse(str,2);
        int[][][] ints = new int[parse.size()][][];
        for (int i = 0 ; i < ints.length;i++){
            if(parse.get(i) instanceof List){
                ints[i] = parsing2(parse.get(i).toString());
            }
        }
        return ints;
    }
}
