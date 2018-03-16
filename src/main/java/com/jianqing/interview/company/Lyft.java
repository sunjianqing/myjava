package com.jianqing.interview.company;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 3/8/18.
 */
public class Lyft {

    /*
        abc + 2 -> cde

        aBC + 2 -> cDE

        xyz + 2 --> zab
     */

    public static void main(String[] args) {
        Lyft lyft = new Lyft();

        String abc = lyft.CeasarCipher("zBC", 2);

//        TreeNode root = new TreeNode(10);
//        TreeNode node1 = new TreeNode(8);
//        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(9);
//        TreeNode node4 = new TreeNode(12);
//        TreeNode node5 = new TreeNode(11);


        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(12);

        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        root.right = node4;
        node4.left = node5;
        node4.right = node6;

        lyft.MostFrequentMember(root);

        System.out.println(abc);

    }
    public String CeasarCipher(String s, int n){
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                if(c + 2 > 'z' ){
                    sb.append((char)(c-'y'+'a'));
                }
                else{
                    sb.append((char)(c + 2));
                }
            }
            else{
                if(c + 2 > 'Z' ){
                    sb.append((char)(c-'Y'+'A'));
                }
                else{
                    sb.append((char)(c + 2));
                }
            }
        }

        return sb.toString();
    }

    /*
    Quesion: Find the most frequent element in a binary search tree
left child <= root <= right child
     */
    public int MostFrequentMember(TreeNode root){
        Integer mostFreEle = null;
        int mostFreCnt = 0;
        Integer curEle = null;
        int curCnt = 0;

        TreeNode cur = root;

        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode tmp = stack.pop();
                if(curEle == null){
                    curEle = tmp.val;
                }
                else{
                    if(tmp.val != curEle){
                        curEle = tmp.val;
                        curCnt = 1;
                    }
                    else{
                        curCnt ++;
                        if(curCnt > mostFreCnt){
                            mostFreEle = curEle;
                            mostFreCnt = curCnt;
                        }
                    }
                }

                cur = tmp.right;
            }
        }

        System.out.println("Most frequent element is " + mostFreEle);
        return mostFreEle;

    }
}
