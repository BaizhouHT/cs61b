package deque;


import java.util.Iterator;

/**
 * @Description: data structure, array implementation of deque, circular implementation with double point
 * @Author: Harrison
 * @Date: 2/25/2024 2:28 PM
 * @Version: 1.0
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] arrayDq;
    private int size;
    private int theoHeadIndex; // circular implementation head point for negative des
    private int theoTailIndex; // circular implementation tail point for positive des


    private int indexChange(int indexBefore) {
        return (arrayDq.length+indexBefore)%arrayDq.length;
    }

    public ArrayDeque() {// Constructor
        arrayDq = (T[]) new Object[8];
        size = 0;
        theoHeadIndex = 0;
        theoTailIndex = 0;
    }

    /**
     * maintain head(neg des) and tail(pos des) point, point points the curr head/tail ele
     * tail = (i+length)%length
     * head = (i+length)%length
     * @param removeOrAdd remove = 0; add = 1; reset = -1 (head=0;tail=max(0,size-1));
     * @param negOrPos neg = 0; pos = 1; reset = -1
     */
    private void pointMaintain(int removeOrAdd, int negOrPos) {
        if (removeOrAdd == 1 && negOrPos == 1) {// addLast() called
            theoTailIndex += 1;
        } else if (removeOrAdd == 0 && negOrPos == 1) {// removeLast() called
            theoTailIndex -= 1;
        } else if (removeOrAdd == 1 && negOrPos == 0) {// addFirst() called
            theoHeadIndex -= 1;
        } else if (removeOrAdd == 0 && negOrPos == 0) {// removeFirst() called
            theoHeadIndex += 1;
        } else if (removeOrAdd == -1 && negOrPos == -1) {// reset
            theoHeadIndex = 0;
            theoTailIndex = Math.max(size-1, 0);
        }
    }


    /**
     * memory space optimization, maintain usage factor at least 25%
     * 1. 100% add to 2length
     * 2. < 1/4 minus to 3/5length
     */
    private void resize() {
        if (size == arrayDq.length) {
            T[] temp = (T[]) new Object[arrayDq.length * 2];
            for (int i=theoHeadIndex, j=0; i<=theoTailIndex; i ++, j++ ) {
                temp[j] = arrayDq[indexChange(i)];
            }
            arrayDq = temp;
            pointMaintain(-1,-1);

        } else if(size < (arrayDq.length/4+1)) {
            T[] temp = (T[]) new Object[arrayDq.length*3/5];
            for (int i=theoHeadIndex, j=0; i<=theoTailIndex; i ++, j++ ) {
                temp[j] = arrayDq[indexChange(i)];
            }
            arrayDq = temp;
            pointMaintain(-1,-1);
        }
    }

    @Override
    public void addLast(T item) {
        if (arrayDq.length >= 16 || size >= arrayDq.length) {
            resize();
        }
        if (size == 0) {
            arrayDq[0] = item;
            pointMaintain(-1,-1);
        } else {
            pointMaintain(1, 1);
            arrayDq[indexChange(theoTailIndex)] = item;
        }
        size += 1;
    }

    @Override
    public void addFirst(T item) {
        if (arrayDq.length >= 16 || size >= arrayDq.length) {
            resize();
        }
        if (size == 0) {
            arrayDq[0] = item;
            pointMaintain(-1,-1);
        } else {
            pointMaintain(1, 0);
            arrayDq[indexChange(theoHeadIndex)] = item;
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
        for (int i=theoHeadIndex; i<=theoTailIndex; i ++ ) {
            System.out.print(arrayDq[indexChange(i)] + (i==theoTailIndex?"\n":" "));
        }
    }

    @Override
    public T removeFirst() {
        T itemOut = null;
        if (size == 0) {
            return itemOut;
        }
        itemOut = arrayDq[indexChange(theoHeadIndex)];
        pointMaintain(0, 0);
        size -= 1;
        if (arrayDq.length >= 16 || size >= arrayDq.length) {
            resize();
        }
        return itemOut;
    }

    @Override
    public T removeLast() {
        T itemOut = null;
        if (size == 0) {
            return itemOut;
        }
        itemOut = arrayDq[indexChange(theoTailIndex)];
        pointMaintain(0, 1);
        size -= 1;
        if (arrayDq.length >= 16 || size >= arrayDq.length) {
            resize();
        }
        return itemOut;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index "+ index + " is out of the ArrayList index " + (size-1) + ".");
            return null;
        }
        return arrayDq[indexChange(theoHeadIndex+index)];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> itor = new Iterator<T>() {

            private int currIndex = 0;
            @Override
            public boolean hasNext() {
                return currIndex < size;
            }

            @Override
            public T next() {
                T item = get(currIndex);
                currIndex += 1;
                return item;
            }
        };
        return itor;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof Deque) {
            if (((Deque<?>) o).size() != this.size) {
                return false;
            }
            for (int i=0; i<this.size; i++) {
                if (((Deque<?>) o).get(i) != this.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
