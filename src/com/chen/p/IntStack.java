package com.chen.p;

public interface IntStack {

    boolean push(int value) throws Exception;

    int pop() throws Exception; // remove and get value on top of Stack

    int peek(); // get value on top of Stack

}
