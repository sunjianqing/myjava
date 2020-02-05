package util;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqsun on 7/28/14.
 */
public class PassByReference {
    public static void main(String[] args){
        PassByReference pbr = new PassByReference();
        TreeNode tnode = new TreeNode(2);
        System.out.println("node address is ---- "+tnode);

        pbr.test(tnode);

        System.out.println("after function call the address is same ---- "+tnode);

    }

    public void test(TreeNode node){
        TreeNode ttnode = new TreeNode(3);
        node = ttnode;
        System.out.println("within the function, the variable was assigned by another obj. the address is ----" + node);
    }
}
