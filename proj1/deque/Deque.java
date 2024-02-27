package deque;

import java.util.Iterator;

/**
 * @Description: deque api
 * @Author: Harrison
 * @Date: 2/27/2024 9:52 AM
 * @Version: 1.0
 */
public interface Deque<T>{
    public void addFirst(T item);
    public void addLast(T item);
    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);

}
