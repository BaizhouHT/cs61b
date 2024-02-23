package timingtest;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {

    private static AList<Integer> testAim = new AList<>();
    /**
     * 规范化表格输出
     * @param Ns
     * @param times
     * @param opCounts
     */
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    /**
     * return time cost
     * @param sw
     * @return timeCost double type
     */

    public static double timeAListConstruction(Stopwatch sw) {
        // TODO: YOUR CODE HERE
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void main(String[] args) {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);

        for (int i=0; i<Ns.size(); i++) {
            opCounts.addLast(Ns.get(i));
            Stopwatch sw = new Stopwatch();
            for (int j=0; j<Ns.get(i); j++) {
                testAim.addLast(1);
            }
            times.addLast(timeAListConstruction(sw));
        }

        printTimingTable(Ns, times, opCounts);

    }


}
