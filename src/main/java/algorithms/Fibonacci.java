package algorithms;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacciLoop(30L); // 0,5 seconds
         long start = System.currentTimeMillis();
         fibonacciRecursive(45); // 7 seconds!
         long end = System.currentTimeMillis();
         System.out.println(end - start);
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static long fibonacciLoop(long n) {
        long first = 0;
        long second = 1;
        long result = n;
        long start = System.currentTimeMillis();
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
            System.out.println(result);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return result;
    }
}
