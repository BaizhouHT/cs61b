package randomizedtest;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Description: compared test
 * @Author: Harrison
 * @Date: 2/23/2024 4:20 PM
 * @Version: 1.0
 */
public class testThreeAddThreeRemove {

    @Test
    public void compareTestANRandBA() {
        // anr add
        AListNoResizing anr = new AListNoResizing();
        anr.addLast(4);
        anr.addLast(5);
        anr.addLast(6);

        // ba add
        BuggyAList ba = new BuggyAList();
        ba.addLast(4);
        ba.addLast(5);
        ba.addLast(6);

        assertEquals(anr.size(), ba.size());
        for (int i=0; i<3; i++) {
            // remove both
            // compare
            assertEquals(anr.removeLast(), ba.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LB = new BuggyAList<>();

        int N = 999;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LB.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeLb = LB.size();
                assertEquals(size, sizeLb);
            } else if (operationNumber == 2 && L.size() != 0) {
                // getLast
                int last = L.getLast();
                int lastLb = LB.getLast();
                assertEquals(last, lastLb);
            }
            else if (operationNumber == 3 && L.size() != 0) {
                // removeLast
                int remove = L.removeLast();
                int removeLb = LB.removeLast();
                assertEquals(remove, removeLb);
            }
        }
    }

}
