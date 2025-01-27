package week4.ex;

public class FibonacciBottomUp {

    public static void main(String[] args) {
        int n = 50;

        // 0부터 n까지 저장할 배열
        long[] fib = new long[n + 1];

        // 초기값
        fib[0] = 0;
        fib[1] = 1;

        // 작은 문제(0,1)부터 시작해 순서대로 누적
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // 결과
        System.out.println("F(" + n + ") = " + fib[n]);
    }
}
