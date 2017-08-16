package com.jianqing.interview.uber;

import java.util.LinkedList;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
// Pretty print tree
// Given you binary tree, print this tree , make it looks a tree.
//      5
//     /  \
//   4    8
//           \
//           9
//          /
//         1
//       /
//       2
//          5
//     4       8
//   #   #   #   9
//   # # # # # # 1 #
//         2
//       [4, 8]
//       4 <-" "<-8
//       [9]

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

class helper{
    int index;
    Node node;

    public helper(int index, Node node){
        this.index = index;
        this.node = node;
    }
}


public class Uber {
    public static void main(String[] args){


        Uber uber = new Uber();
        Node root = new Node(5);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        root.left = node4;
        root.right = node8;

        Node node9 = new Node(9);
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node8.right = node9;
        node9.left = node1;
        node1.left = node2;

        uber.solution(root);

    }

    public void solution(Node root) {
        if(root == null)
            return;

        LinkedList<helper> queue = new LinkedList<helper>();
        queue.add(new helper(1, root));
        System.out.println(root.val);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len; i++){
                helper h = queue.poll();
                if(h.node != null && h.node.left != null){
                    queue.add(new helper(h.index * 2, h.node.left));
                }
                else{
                    queue.add(new helper(h.index * 2, null));
                }
                if(h.node != null && h.node.right != null){
                    queue.add(new helper(h.index * 2 + 1, h.node.right));
                }
                else{
                    queue.add(new helper(h.index * 2 + 1, null));
                }
            }
            // print out content in queue

            LinkedList<helper> tmp = new LinkedList(queue);
            for(int i = 0 ; i < tmp.size(); i++){
                if(tmp.get(i).node != null)
                    System.out.print(tmp.get(i).node.val);
                else
                    System.out.print(" ");

                System.out.print(" ");

            }
            System.out.println();


            //[(2,node 4),(3, node 8)]
            //[(4," "), (5," "), (6," ") , (7, "9")]
            //       [1]
            //     [2]     [3]
            //  [4] [5]  [6] [7]
        }
    }

}



