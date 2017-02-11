package com.jianqing.interview.leetcode16;

import java.util.Iterator;

/**
 * Created by jianqing_sun on 2/9/17.
 */
public class PeekingIterator_284 implements Iterator<Integer> {

    Integer peek = null;
    boolean flag = false;
    Iterator iter;
    // 1,2,3,4
    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        if(flag == false) {
            peek = (Integer) iter.next();
            flag = true;
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
       if( flag ){
           flag = false;
           return peek;
       }
       else {
           peek = (Integer) iter.next();
           return peek;
       }
    }

    @Override
    public void remove() {
        iter.remove();
    }

    @Override
    public boolean hasNext() {
        if ( flag )
            return true;
        else {
            return iter.hasNext();
        }
    }
}
