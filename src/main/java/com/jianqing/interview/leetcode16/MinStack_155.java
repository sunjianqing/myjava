package com.jianqing.interview.leetcode16;

import java.util.Stack;

/**
 * Created by jianqingsun on 6/23/17.
 *
 * 两个Stack 搞定
 *
 */
public class MinStack_155 {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        MinStack_155 ms = new MinStack_155();
        ms.push(512);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(512);
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
        System.out.println(ms.getMin());


    }
    public MinStack_155() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer x = stack.pop();
        if(x.equals( minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /*
        O(1) Space
        private int min_val = Integer.MAX_VALUE;
    private Stack<Integer> s = new Stack<>();

    public void push(int x) {
        if (x <= min_val) {
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }

    public void pop() {
        if (s.pop() == min_val) min_val = s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min_val;
    }

     */
}


