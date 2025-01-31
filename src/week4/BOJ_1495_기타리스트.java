package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1495_기타리스트 {

    private static int N;
    private static int S;
    private static int M;
    private static int[] volumes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, S, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 곡마다 변경할 볼륨 차이(volumes) 입력
        volumes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        // 3. DP 배열 정의
        // dp[i][v] : i번째 곡을 연주하기 "직전"에 볼륨 v로 설정 가능 여부
        boolean[][] dp = new boolean[N + 1][M + 1];

        // 4. 초기 상태
        // 시작 시점(0번째 곡 전), 볼륨 S는 가능
        dp[0][S] = true;

        // 5. 곡을 순서대로 진행하며 dp 갱신
        for (int i = 1; i <= N; i++) {
            int diff = volumes[i - 1];  // i번째 곡 앞에서 바꿀 수 있는 볼륨 차
            for (int currentVolume = 0; currentVolume <= M; currentVolume++) {
                // 만약 이전 곡에서 currentVolume 이 가능했다면,
                if (dp[i - 1][currentVolume]) {
                    // 1) +diff
                    int plus = currentVolume + diff;
                    if (plus <= M) {
                        dp[i][plus] = true;
                    }
                    // 2) -diff
                    int minus = currentVolume - diff;
                    if (minus >= 0) {
                        dp[i][minus] = true;
                    }
                }
            }
        }

        // 6. 마지막 곡(N번째)에서 가능한 볼륨 중 최댓값 탐색
        int answer = -1;
        for (int v = M; v >= 0; v--) {
            if (dp[N][v]) {
                answer = v;
                break;
            }
        }

        // 7. 결과 출력
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
