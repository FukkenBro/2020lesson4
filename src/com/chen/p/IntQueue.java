package com.chen.p;

public interface IntQueue {

    boolean add(int value);

    int remove() throws Exception; // return first in Queue but and remove it

    int element(); // return first in Queue but not remove it

}
