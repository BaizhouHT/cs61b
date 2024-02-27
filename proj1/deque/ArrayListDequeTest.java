package deque;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayListDequeTest {

    @Test
    /**
     * addLast(), isEmpty(), size()
     * Adds a few things to the tail of list deque, checking isEmpty() and size() are correct,
     * && is the "and" operation.
     */
    public void addLastIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addLast("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

    }

    @Test
    /**
     * resize()
     * Adds some tail item, check resized arr size
     * 1. 扩展没问题
     * 2. 复制没问题
     */
    public void addLastResize() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        int test = 10;
        for (int i=0; i<test; i++) {
            lld1.addLast(i);
        }
        lld1.printDeque();
    }

    @Test
    /**
     * addLast(), printDeque(), removeLast()
     * Adds a few things to the tail of list deque, checking print() result is right or not.
     */
    public void addLastAndPrintTestAndRemoveLast() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        lld1.printDeque();

        assertEquals("back",lld1.removeLast());
        assertEquals("middle",lld1.removeLast());
        assertEquals("front",lld1.removeLast());
        assertEquals(0,lld1.size());
    }

    @Test
    /**
     * addFirst(), isEmpty(), size()
     * Adds a few things to the head of list deque, checking isEmpty() and size() are correct,
     * && is the "and" operation.
     */
    public void addFirstIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addFirst("middle");
        assertEquals(2, lld1.size());

        lld1.addFirst("back");
        assertEquals(3, lld1.size());

    }

    @Test
    /**
     * resize()
     * Adds some head item, check resized arr size
     * 1. 扩展没问题
     * 2. 复制没问题
     */
    public void addFirstResize() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        int test = 10;
        for (int i=0; i<test; i++) {
            lld1.addFirst(i);
        }
        lld1.printDeque();
    }

    @Test
    /**
     * addFirst(), printDeque(), removeFirst()
     * Adds a few things to the head of list deque, checking print() result is right or not.
     */
    public void addFirstAndPrintTestAndRemoveLast() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        lld1.addFirst("front");
        lld1.addFirst("middle");
        lld1.addFirst("back");
        lld1.printDeque();

        assertEquals("back",lld1.removeFirst());
        assertEquals("middle",lld1.removeFirst());
        assertEquals("front",lld1.removeFirst());
        assertEquals(0,lld1.size());
    }

    @Test
    /**
     * Tests removing from an empty deque
     */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /**
     * Check if you can create ArrauListDeques with different parameterized types
     */
    public void multipleParamTest() {
        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /**
     * check if null is return when removing from an empty ArrauListDeque.
     */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /** resize()
     * Add large number of elements to deque; check if order is correct.
     */

    public void bigLLDequeTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /** check iteration get item
     * finally check the getting process
     */
    public void testGetItem() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        // size = 10
        lld1.addFirst("4");
        lld1.addLast("5");
        lld1.addFirst("3");
        lld1.addFirst("2");
        lld1.addLast("6");
        lld1.addFirst("1");
        lld1.addFirst("0");
        lld1.addLast("7");
        lld1.addLast("8");
        lld1.addLast("9");
        assertEquals(10, lld1.size());
        for (int i=0;i<10;i++) {
            assertEquals(lld1.get(i), String.valueOf(i));
        }
    }

    @Test
    /** compare test, focus on ...last()
     * finally check the 2 implementation deque difference
     */
    public void randomizedTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> LB = new ArrayDeque<>();

        int addedSize = 0;
        int N = 999;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LB.addLast(randVal);
                addedSize += 1;
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeLb = LB.size();
                assertEquals(size, sizeLb);
            } else if (operationNumber == 2 && L.size() != 0) {
                // getLast
                int randomIndex = StdRandom.uniform(0, addedSize);
                int last = L.get(randomIndex);
                int lastLb = LB.get(randomIndex);
                assertEquals(last, lastLb);
            } else if (operationNumber == 3 && L.size() != 0) {
                // removeLast
                int remove = L.removeLast();
                int removeLb = LB.removeLast();
                addedSize -= 1;
                assertEquals(remove, removeLb);
            } else if (operationNumber == 4) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                LB.addFirst(randVal);
                addedSize += 1;
            } else if (operationNumber == 5 && L.size() != 0) {
                // removeFirst
                int remove = L.removeFirst();
                int removeLb = LB.removeFirst();
                addedSize -= 1;
                assertEquals(remove, removeLb);
            }
        }
    }

    @Test
    /** MaxArrayDeque(...), max()
     * max array list ele test, comparator test
     */
    public void maxArrayDequeTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
//        ArrayDeque<Integer> LB = new ArrayDeque<>();
        MaxArrayDeque<Integer> LB = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int addedSize = 0;
        int N = 999;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LB.addLast(randVal);
                addedSize += 1;
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeLb = LB.size();
                assertEquals(size, sizeLb);
            } else if (operationNumber == 2 && L.size() != 0) {
                // getLast
                int randomIndex = StdRandom.uniform(0, addedSize);
                int last = L.get(randomIndex);
                int lastLb = LB.get(randomIndex);
                assertEquals(last, lastLb);
            } else if (operationNumber == 3 && L.size() != 0) {
                // removeLast
                int remove = L.removeLast();
                int removeLb = LB.removeLast();
                addedSize -= 1;
                assertEquals(remove, removeLb);
            } else if (operationNumber == 4) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                LB.addFirst(randVal);
                addedSize += 1;
            } else if (operationNumber == 5 && L.size() != 0) {
                // removeFirst
                int remove = L.removeFirst();
                int removeLb = LB.removeFirst();
                addedSize -= 1;
                assertEquals(remove, removeLb);
            }
        }
        int test = LB.max();
        System.out.println(test);

        int test1 = LB.max(new Comparator<Integer>() {// min test
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(test1);

        assertTrue(LB.equals(L));
        assertTrue(L.equals(LB));


    }

    @Test
    /**
     * Iterator test
     */
    public void iteratoTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        lld1.printDeque();

        while (lld1.iterator().hasNext()) {
            System.out.println(lld1.iterator().next());
        };
    }
}
