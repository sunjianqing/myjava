package util;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/24/13
 * Time: 9:16 AM
 * To change this template use File | Settings | File Templates.
 */
class StringTest{
    public static void main(String[] args){
        String s = "hello world";
        for(int i = 0 ; i < s.length() ; i++){
            System.out.print(s.charAt(i));
        }
    }
}
