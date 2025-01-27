package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

    private static int N;        // 계단의 개수
    private static int[] scores; // 각 계단의 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 계단 수 N 입력
        N = Integer.parseInt(br.readLine());

        // 2. 각 계단에 쓰인 점수 배열 scores 초기화
        scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        // 3. 최대 점수를 구해 출력
        System.out.print(getMaxScores());
    }

    /**
     * 동적 프로그래밍(DP)을 사용하여
     * N번째 계단까지 올라왔을 때 얻을 수 있는 '최대 점수'를 계산한다.
     *
     * @return 계단의 가장 위(N-1 인덱스)까지 왔을 때 얻을 수 있는 최대 점수
     */
    private static int getMaxScores() {
        // 계단이 1개뿐인 경우: 첫 계단 점수가 곧 답
        if (N == 1) {
            return scores[0];
        }
        // 계단이 2개뿐인 경우: 두 계단 모두 밟는 것이 최대
        else if (N == 2) {
            return scores[0] + scores[1];
        }

        // dp[i] = i번째 계단까지 올라왔을 때 얻을 수 있는 최대 점수
        int[] dp = new int[N];

        // 초기값 설정
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        // 3번째 계단(i=2)까지의 최대 점수:
        //  - 두 번째 계단 + 세 번째 계단 밟기 (scores[1] + scores[2])
        //  - 첫 번째 계단 + 세 번째 계단 밟기 (scores[0] + scores[2])
        dp[2] = Math.max(scores[1] + scores[2], scores[0] + scores[2]);

        // 점화식:
        //   dp[i] = 아래 중 더 큰 값
        //     (1) dp[i-2] + scores[i]
        //          -> 바로 전(i-1) 계단을 건너뛰고 i계단을 밟는 경우 (연속 2번)
        //     (2) dp[i-3] + scores[i-1] + scores[i]
        //          -> (i-2) 계단을 건너뛰고 i-1, i 계단을 연속으로 밟는 경우
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + scores[i],
                    dp[i - 3] + scores[i - 1] + scores[i]
            );
        }

        // N-1번째 계단(마지막 계단)까지 올라왔을 때의 최대 점수
        return dp[N - 1];
    }
}
