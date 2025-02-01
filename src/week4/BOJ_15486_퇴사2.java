package week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

    private static int N;
    private static int[] T; // 상담 걸리는 일수
    private static int[] P; // 상담 완료 시 수익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력 받기
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 2. dp 배열 생성 (N+2 크기로, 인덱스 편의)
        // dp[i] : i번째 날까지 고려했을 때의 최대 수익
        int[] dp = new int[N + 2];

        // 3. 보텀업 방식으로 dp 채우기
        for (int i = 1; i <= N; i++) {
            // (1) i일에 상담하지 않고 넘어가는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // (2) i일에 상담을 하는 경우 (i + T[i]일에 끝)
            int nextDay = i + T[i];
            if (nextDay <= N + 1) { // 퇴사일(N+1)을 넘지 않는 경우만
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + P[i]);
            }
        }

        // 4. 결과: dp[N+1]이 최대 수익
        int maxProfit = dp[N + 1];

        // 5. 출력
        bw.write(String.valueOf(maxProfit));
        bw.close();
    }
}
