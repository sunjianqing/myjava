package util;

import java.util.LinkedList;

/**
 * Created by jianqsun on 5/14/14.
 */
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");

        System.out.println(list);

    }
}
