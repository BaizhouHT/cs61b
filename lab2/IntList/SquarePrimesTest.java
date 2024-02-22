package IntList;

import static org.junit.Assert.*;

import jh61b.junit.In;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    /**
     * positive-test
     * test the last element
     * @inference: iteration failed
     */
    @Test
    public void testSquarePrimesSimple2() {
        IntList lst = IntList.of(14, 15, 16, 17, 17);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 289", lst.toString());
        assertTrue(changed);;
    }

    /**
     * positive-test
     * test the first element
     * @inference: iteration failed
     */
    @Test
    public void testSquarePrimesSimple3() {
        IntList lst = IntList.of(17, 17, 16, 17, 17);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("289 -> 289 -> 16 -> 289 -> 289", lst.toString());
        assertTrue(changed);;
    }

    /**
     * anti-test
     * test the primes check which is changed variable
     */
    @Test
    public void testSquarePrimesSimple4() {
        IntList lst = IntList.of(14, 15, 16, 26, 32);
        boolean changed = !IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 26 -> 32", lst.toString());
        assertTrue(changed);;
    }
}
