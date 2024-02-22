package Disussion.IntroToJava;

/**
 * 3 Writing Your First Program
 * Implement fib which takes in an integer n and returns the nth Fibonacci number.
 * You may not need to use all the lines.
 * The Fibonacci sequence is 0, 1, 1, 2, 3, 5, 8, 13, 21,...
 * The first two numbers in the sequence are 0 and 1,
 * and every number thereafter it is the sum of the two numbers in the sequence before it.
 */
public class task3 {

    /**
     * Brute-Force recursion
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 2) {
            return n-1;
        }
        return fib(n-1) + fib(n-2);
    }


    /**
     * Memoization Optimization, dynamic programming
     * time Complexity: O(n)
     * space Complexity: O(n)
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 2) {
            return n-1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }


    /**
     * Memoization Optimization, dynamic programming, rolling optimization
     * time Complexity: O(n)
     * space Complexity: O(1)
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n <= 2) {
            return n-1;
        }
        int prev2 = 0;int prev1 = 1;int curr = 1;
        for (int i=2; i<n; i++) {
            curr = prev2 + prev1;
            int temp = prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib(9));
        System.out.println(fib2(9));
        System.out.println(fib3(9));
    }
}
