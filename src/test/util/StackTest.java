package util;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackTest {
    public  static  void  main(String[] args){
        GenStack<String> stack = new GenStack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.pop());
    }
}
