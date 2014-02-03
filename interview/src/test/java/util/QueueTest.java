package util;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueTest {
    public static void main(String[] args){
        GenQueue<String> queue = new GenQueue<String>();
        queue.enqueue("A");
        queue.enqueue("C");
        queue.enqueue("B");

        queue.print();
        while (queue.hasItems()){
            System.out.println(queue.dequeue());
        }


    }
}
