package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/24/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayListTest {
    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<Integer>();

        List list = new LinkedList();
        
        al.add(0,1);
        al.add(0,1);
        //al.remove(1);
        Iterator<Integer> it = al.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }





    }
}
