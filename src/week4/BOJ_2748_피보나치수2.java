package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2748_피보나치수2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n (구하고자 하는 피보나치 수의 인덱스) 입력
        int n = Integer.parseInt(br.readLine());

        // 2. n번째 피보나치 수 계산 및 출력
        bw.write(String.valueOf(getFibonacciNumber(n)));
        bw.close();
    }

    /**
     * n번째 피보나치 수를 반환하는 메서드.
     *
     * fib[0]부터 fib[n]까지 차례대로 계산한다.
     *
     * fib[0] = 0
     * fib[1] = 1
     * fib[i] = fib[i-1] + fib[i-2]  (i >= 2)
     *
     * @param n 구하고자 하는 피보나치 수의 인덱스
     * @return n번째 피보나치 수 (long 범위)
     */
    private static long getFibonacciNumber(int n) {
        // n=0인 경우 피보나치 수는 0
        if (n == 0) {
            return 0;
        }
        // n=1인 경우 피보나치 수는 1
        else if (n == 1) {
            return 1;
        }

        // fib[i]: i번째 피보나치 수 저장
        long[] fib = new long[n + 1];

        // 초기값 설정
        fib[0] = 0;
        fib[1] = 1;

        // 2 ~ n까지 순서대로 채움
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // fib[n]이 n번째 피보나치 수
        return fib[n];
    }
}
