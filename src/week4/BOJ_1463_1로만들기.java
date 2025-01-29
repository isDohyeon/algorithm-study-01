package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1463_1로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        // 2. DP 배열 초기화
        int[] dp = new int[N + 1];
        dp[1] = 0;  // 1은 이미 1이므로 연산이 필요 없음

        // DP 배열 채우기
        for (int i = 2; i <= N; i++) {
            // 기본적으로 이전 수에서 1을 뺀 경우
            dp[i] = dp[i - 1] + 1;
            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        // n을 1로 만드는 데 필요한 최소 연산 = dp[N];
        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}
