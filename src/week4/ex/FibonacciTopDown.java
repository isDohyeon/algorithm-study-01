package week4.ex;

public class FibonacciTopDown {
    // 메모이제이션을 위한 배열
    // fibMemo[n] = F(n)을 저장
    private static long[] fibMemo;

    public static void main(String[] args) {
        int n = 50; // 예: 50번째 피보나치
        fibMemo = new long[n + 1];

        // 초기값 설정 (아직 계산 안 됨을 0으로)
        // F(0)과 F(1)은 직접 할당해도 됨 (원하면)

        long result = fibonacci(n);
        System.out.println("F(" + n + ") = " + result);
    }

    /**
     * 탑다운 방식의 피보나치: 필요한 순간에만 재귀로 호출,
     * 이미 구한 값은 메모이제이션 배열에서 꺼냄.
     */
    private static long fibonacci(int n) {
        // 기저 사례
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 이미 계산된 값이라면 재활용
        if (fibMemo[n] != 0) {
            return fibMemo[n];
        }

        // 계산이 안 되었다면 재귀 호출로 구하고 저장
        fibMemo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fibMemo[n];
    }
}
