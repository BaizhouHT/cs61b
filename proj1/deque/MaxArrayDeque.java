package deque;


import java.util.Comparator;

/**
 * @Description: find the maximum ele of the array deque
 * @Author: Harrison
 * @Date: 2/25/2024 2:28 PM
 * @Version: 1.0
 */
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {// Constructor
        super();
        comparator = c;
    }

    public T max() {// using initial comparator
        if (isEmpty()) {
            return null;
        }
        T maxiEle = (T) get(0);
        for (int i=0; i<size(); i++) {
            if (comparator.compare((T) get(i), maxiEle) > 0) {
                maxiEle = (T) get(i);
            }
        }
        return maxiEle;
    }

    public T max(Comparator<T> c) {// overload max() using new override comparator
        if (isEmpty()) {
            return null;
        }
        T maxiEle = (T) get(0);
        for (int i=0; i<size(); i++) {
            if (c.compare((T) get(i), maxiEle) > 0) {
                maxiEle = (T) get(i);
            }
        }
        return maxiEle;
    }
}
