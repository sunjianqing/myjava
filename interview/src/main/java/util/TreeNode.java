package util;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int val){
        value = val;
    }

    public String toString(){
        return String.valueOf(value);
    }
}
