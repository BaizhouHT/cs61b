package deque;

import java.util.Iterator;

/**
 * @Description: data structure, linkedList implementation of deque, use circular sentinel topology
 * @Author: Harrison
 * @Date: 2/24/2024 12:03 PM
 * @Version: 1.0
 */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node<T> {
        private T item;
        private Node next;
        private Node prev;
        private Node(T item, Node prev, Node next) {
            // Original Constructor
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }


    /**
     * origin node of circular deque
     */
    private Node sentinelOrigin;
    private int size;

    /**
     * Constructor of deque, initialize an empty deque
     */
    public LinkedListDeque() {
        sentinelOrigin = new Node(999, null, null);
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node temp = new Node(item, null, null);
        if (size == 0) {
            sentinelOrigin.next = temp;
            sentinelOrigin.prev = temp;
            temp.prev = sentinelOrigin;
            temp.next = sentinelOrigin;
        } else {
            temp.next = sentinelOrigin.next;
            temp.prev = sentinelOrigin;
            sentinelOrigin.next.prev = temp;
            sentinelOrigin.next = temp;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node temp = new Node(item, null, null);
        if (size == 0) {
            sentinelOrigin.next = temp;
            sentinelOrigin.prev = temp;
            temp.prev = sentinelOrigin;
            temp.next = sentinelOrigin;
        } else {
            temp.prev = sentinelOrigin.prev;
            temp.next = sentinelOrigin;
            sentinelOrigin.prev.next = temp;
            sentinelOrigin.prev = temp;
        }
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) {
            System.out.println();
            return;
        }
        Node temp = sentinelOrigin;
        while (temp.next != sentinelOrigin) {
            temp = temp.next;
            System.out.println(temp.item + (temp.next.equals(sentinelOrigin) ? "\n" : " "));
        }
    }

    @Override
    public T removeFirst() {
        T removeEle = null;
        if (size == 0) {
            return removeEle;
        }
        removeEle = (T) sentinelOrigin.next.item;
        sentinelOrigin.next.next.prev = sentinelOrigin;
        sentinelOrigin.next = sentinelOrigin.next.next;
        size -= 1;
        return removeEle;
    }

    @Override
    public T removeLast() {
        T removeEle = null;
        if (size == 0) {
            return removeEle;
        }
        removeEle = (T) sentinelOrigin.prev.item;
        sentinelOrigin.prev.prev.next = sentinelOrigin;
        sentinelOrigin.prev = sentinelOrigin.prev.prev;
        size -= 1;
        return removeEle;
    }

    @Override
    public T get(int index) {
        T item = null;
        Node temp = sentinelOrigin.next;
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = 0; i <= index; i++) {
            item = (T) temp.item;
            temp = temp.next;
        }
        return item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            System.out.println("Index " + index + " is out of the list index " + (size - 1) + ".");
            return null;
        }
        return recursiveProcess(index, sentinelOrigin);
    }

    private T recursiveProcess(int recDeepth, Node sen) {
        if (recDeepth == 0) {
            return (T) sen.next.item;
        }
        recDeepth -= 1;
        return (T) recursiveProcess(recDeepth, sen.next);
    }

    public Iterator<T> iterator() {
        Iterator<T> itor = new Iterator<T>() {
            private Node<T> iteratorNode = sentinelOrigin.next;
            @Override
            public boolean hasNext() {
                return iteratorNode != sentinelOrigin && iteratorNode != null;
            }

            @Override
            public T next() {
                T item = iteratorNode.item;
                iteratorNode = iteratorNode.next;
                return item;
            }

        };
        return itor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        if (o instanceof ArrayDeque) {
            ArrayDeque<T> other = (ArrayDeque<T>) o;
            if (other.size() != this.size) {
                return false;
            }
            Iterator<T> thisIt = iterator();
            Iterator<T> otherIterator = other.iterator();
            while (thisIt.hasNext()) {
                if (!thisIt.next().equals(otherIterator.next())) {
                    return false;
                }
            }
            return true;
        } else if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> other = (LinkedListDeque<T>) o;
            if (other.size() != this.size) {
                return false;
            }
            Iterator<T> thisIt = iterator();
            Iterator<T> otherIterator = other.iterator();
            while (thisIt.hasNext()) {
                if (!thisIt.next().equals(otherIterator.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
