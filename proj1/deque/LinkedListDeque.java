package deque;

import java.util.Iterator;

/**
 * @Description: data structure, linkedList implementation of deque, use circular sentinel topology
 * @Author: Harrison
 * @Date: 2/24/2024 12:03 PM
 * @Version: 1.0
 */
public class LinkedListDeque<T> {

    private class Node<T> {
        private T item;
        private Node next;
        private Node prev;
        public Node(T item, Node prev, Node next) {// Original Constructor
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }


    /**
     * origin node of circular deque
     */
    public Node sentinelOrigin;
    private int size;

    /**
     * Constructor of deque, initialize an empty deque
     */
    public LinkedListDeque() {
        sentinelOrigin = new Node(999, sentinelOrigin,sentinelOrigin); //TODO: fix the null mis
//        currNode = sentinelOrigin;
        size = 0;
    }

    public void addFirst(T item) {
        Node new1stNode = new Node(item, null, null);
        // update in
        new1stNode.prev = sentinelOrigin;
        new1stNode.next = sentinelOrigin.next;
        System.out.println(sentinelOrigin.next);
        System.out.println(new1stNode.next);
        // update in.next(in+1)
        new1stNode.next.prev = new1stNode;
        // update sentinel
        sentinelOrigin.next = new1stNode;
        if (sentinelOrigin.prev == sentinelOrigin) {
            sentinelOrigin.prev = new1stNode;
        }
        size += 1;
    }

    public void addLast(T item) {
        Node newLastNode = new Node(item, null, null);
        // update in
        newLastNode.prev = sentinelOrigin.prev;
        newLastNode.next = sentinelOrigin;
        // update in.prev(in-1)
        newLastNode.prev.next = newLastNode;
        // update sentinel
        sentinelOrigin.prev = newLastNode;
        if (sentinelOrigin.next == sentinelOrigin) {
            sentinelOrigin.next = newLastNode;
        }
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println();
            return;
        }
        Node temp = sentinelOrigin;
        while (temp.next != sentinelOrigin) {
            temp = temp.next;
            System.out.println(temp.item + " ");
        }
    }

    public T removeFirst() {
        if (sentinelOrigin.next == sentinelOrigin) {
            return null;
        }
        T removeEle = (T) sentinelOrigin.next.item;
        if (sentinelOrigin.next.next != null) {// after remove size > 0
            sentinelOrigin.next.next.prev = sentinelOrigin;
            sentinelOrigin.next = sentinelOrigin.next.next;
        } else {// after remove size = 0
            sentinelOrigin.next = sentinelOrigin;
            sentinelOrigin.prev = sentinelOrigin;
        }
        size -= 1;
        return removeEle;
    }

    public T removeLast() {
        if (sentinelOrigin.prev == sentinelOrigin) {
            return null;
        }
        T removeEle = (T) sentinelOrigin.prev.item;
        if (sentinelOrigin.prev.prev != null) {// after remove size > 0
            sentinelOrigin.prev.prev.next = sentinelOrigin;
            sentinelOrigin.prev = sentinelOrigin.prev.prev;
        } else {// after remove size = 0
            sentinelOrigin.prev = sentinelOrigin;
            sentinelOrigin.next = sentinelOrigin;
        }
        return removeEle;
    }

    public T get(int index) {
        if (size == 0) {
            System.out.println("List size is 0");
            return null;
        }
        T item = null;
        Node temp = sentinelOrigin.next;
        try {
            for (int i=0; i<index; i++) {
                item = (T) temp.item;
                temp = temp.next;
            }
        } catch (Exception e) {
            System.out.println("Index "+ index + " is out of the list index " + (size-1) + ".");
        }
        return item;
    }

    public T getRecursive(int index) {
        return recursiveProcess(index, sentinelOrigin);
    }

    private T recursiveProcess(int recDeepth, Node sen) {
        if (recDeepth == 0) {
            return (T) sen.item;
        }
        recDeepth -= 1;
        recursiveProcess(recDeepth, sen.next);
        return null;
    }

//    public Iterator<T> iterator() {
//        return null;
//    }
//
//    public boolean equals(Object o) {
//        return false;
//    }
}
