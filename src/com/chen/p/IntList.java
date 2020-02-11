package com.chen.p;

public interface IntList {

    boolean add(int element);

    boolean add(int index, int element) throws Exception;

    void clear() throws Exception;

    int get(int index);

    boolean isEmpty();

    boolean remove(int index) throws Exception;

    boolean removeByValue(int value) throws Exception;

    boolean set(int index, int element) throws Exception;

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();

}
