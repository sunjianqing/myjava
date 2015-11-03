package util;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();
    public void enqueue(E item) {
        list.addLast(item);
    }
    public E dequeue() {
        return list.poll();
    }
    public boolean hasItems() {
        return !list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public void addItems(GenQueue<E> q) {
        while (q.hasItems())
            list.addLast(q.dequeue());
    }

    /**
     * dequeue element from the queue entry
     */

    public E dequeueFromEntry(){
        return list.pollLast();
    }

    public void print(){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).toString()+" ");
        }

    }
}
