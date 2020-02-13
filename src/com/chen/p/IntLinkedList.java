package com.chen.p;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private int size;
    private Entry first;
    private Entry last;

    private Entry getEntry(int index) {
        if (index == 0) {
            return first;
        }
        if (index == size) {
            return last;
        }
        if (index < size / 2) {
            Entry tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Entry tmp = last;
            int n = size - 1;
            for (int i = 0; i < n - index; i++) {
                tmp = tmp.previous;
            }
            return tmp;
        }

    }

    private void validateIndex(int index) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Index out of range");
        }
    }

    private void validateSize() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
    }

    @Override
    public boolean add(int value) {
        Entry newNode = new Entry(value);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int value) throws Exception {
        validateIndex(index);
        Entry newNode = new Entry(value);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else if (index == size) {
            add(value);
            return true;
        } else if (index == 0) {
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
        } else {
            Entry prevIndex = this.getEntry(index - 1);
            Entry nextIndex = this.getEntry(index);
            prevIndex.setNext(newNode);
            nextIndex.setPrevious(newNode);
            newNode.setNext(nextIndex);
            newNode.setPrevious(prevIndex);
        }
        size++;
        return true;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.data;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public void clear() throws Exception {
        validateSize();
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int get(int index) {
        if (index < size / 2) {
            Entry tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        } else {
            Entry tmp = last;
            int n = size - 1;
            for (int i = n; i > index; i--) {
                tmp = tmp.previous;
            }
            return tmp.data;
        }
    }

    @Override
    public boolean remove(int index) throws Exception {
        validateSize();
        validateIndex(index);
        if (index == size) {
            last = last.previous;
            last.setNext(null);
        } else if (index == 0) {
            first = getEntry(1);
            first.setPrevious(null);
        } else {
            Entry prevIndex = this.getEntry(index - 1);
            Entry nextIndex = this.getEntry(index + 1);
            prevIndex.setNext(nextIndex);
            nextIndex.setPrevious(prevIndex);
        }
        size--;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public int remove() throws Exception {
        Entry tmp = first;
        remove(0);
        return tmp.data;
    }

    @Override
    public int element() {
        return first.data;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean removeByValue(int value) throws Exception {
        Entry tmpHead = first;
        Entry tmpTail = last;
        int n = size - 1;
        for (int i = 0, j = n; i < j; i++, j--) {
            if (tmpHead.data == value) {
                remove(i);
                return true;
            }
            if (tmpTail.data == value) {
                remove(j);
                return true;
            }
            tmpHead = tmpHead.next;
            tmpTail = tmpTail.previous;
        }
        return false;
    }

    @Override
    public boolean set(int index, int data) throws Exception {
        validateSize();
        validateIndex(index);
        getEntry(index).setData(data);
        return true;
    }

    private static class Entry {
        int data;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.data = value;
        }

        protected void setPrevious(Entry previous) {
            this.previous = previous;
        }

        protected void setNext(Entry next) {
            this.next = next;
        }

        protected void setData(int data) {
            this.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) throws Exception {
        int n = toIndex - fromIndex;
        if (n < 0) {
            throw new Exception("Invalid range");
        }
        IntLinkedList tmp = new IntLinkedList();
        Entry tmpEntry = getEntry(fromIndex);
        for (int i = 0; i <= n; i++) {
            tmp.add(tmpEntry.data);
            tmpEntry = tmpEntry.next;
        }
        return tmp;
    }

    @Override
    public boolean push(int value) throws Exception {
        add(0, value);
        return true;
    }

    @Override
    public int pop() throws Exception {
        Entry tmp = first;
        remove(0);
        return tmp.data;
    }

    @Override
    public int peek() {
        return first.data;
    }
}
