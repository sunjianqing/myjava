package com.jianqing.interview.google;

import java.util.Iterator;

/**
 * Created by jianqingsun on 2/7/17.
 */
public class ItofItImpl<E extends Iterator> implements IteratorOfIterator {

    Iterator<E> list;

    @Override
    public boolean hasNext() {
        return list.hasNext() && list.next().hasNext();
    }

    @Override
    public Object next() {
        if (list.next() == null)
            return null;
        else {
            E next = list.next();
            return next.next();
        }
    }

    @Override
    public void remove() {
        if (list.next() == null) {
            list.remove();
        } else {
            list.next().remove();
        }
    }
}
