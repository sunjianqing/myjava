package util;


import com.jianqing.interview.base.ListNode;

import java.util.LinkedList;

/**
 * Created by jianqsun on 5/14/14.
 */
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.addLast("b");
        list.addLast("c");

        list.add("d"); //add is the same as addLast
        System.out.println("The first element is " + list.getFirst());
        // print out a,b,c,d
        System.out.println(list);

        list.remove();
        System.out.println("Remaining list is \n" + list);
        System.out.println("================");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        testListNode(head.next);

        ListNode tmp = head;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

    }

    public static void testListNode(ListNode node){
        ListNode node1 = new ListNode(3);
        node.next = node1;

    }
}
