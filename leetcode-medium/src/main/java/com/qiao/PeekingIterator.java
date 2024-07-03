package com.qiao;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 */
public class PeekingIterator implements Iterator<Integer> {

    private int pointer = 0;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        return 0;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
