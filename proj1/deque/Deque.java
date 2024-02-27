package deque;

/**
 * @Description: deque api
 * @Author: Harrison
 * @Date: 2/27/2024 9:52 AM
 * @Version: 1.0
 */
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

}
