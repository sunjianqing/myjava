package util;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenStack<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public E pop(){
        return list.pollLast();
    }

    public void push(E ele){
        list.addLast(ele);
    }
}
