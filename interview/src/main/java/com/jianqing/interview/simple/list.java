package com.jianqing.interview.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianqsun on 8/22/14.
 */
public class list {

    //Reverse list
    public static List<String> reverse(List<String> list) {
        if(list == null)
            return null;

        if(list.isEmpty())
            return list;

        int j = list.size() - 1;

        int i = 0 ;

        while(i<=j){
            String tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
            i++;
            j--;
        }

        return list;
    }

}
