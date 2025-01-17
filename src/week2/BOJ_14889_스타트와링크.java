package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

    private static int N;
    private static int[][] S;
    private static int powerGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, S 입력
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 두 팀으로 나누는 모든 조합 탐색
        boolean[] startTeam = new boolean[N];
        findMinPowerGap(startTeam, 0, 0);
        // 4. 결과 출력
        bw.write(String.valueOf(powerGap));
        bw.close();
    }

    private static void findMinPowerGap(boolean[] startTeam, int number, int depth) {
        // 3. 팀이 나누어졌으면 능력치 차이를 계산
        if (depth >= N / 2) {
            calculateTeamGap(startTeam);
            return;
        }
        for (int i = number; i < N; i++) {
            if (!startTeam[i]) {
                // i번째 사람 선택
                startTeam[i] = true;
                // 다음 사람으로 넘어가기
                findMinPowerGap(startTeam, i + 1, depth + 1);
                // 재귀가 끝난 이후 다른 조합을 탐색하기 위해 선택해제
                startTeam[i] = false;
            }
        }
    }

    private static void calculateTeamGap(boolean[] startTeam) {
        int startTeamPower = 0;
        int linkTeamPower = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (startTeam[i] && startTeam[j]) {
                    startTeamPower += S[i][j];
                } else if (!startTeam[i] && !startTeam[j]) {
                    linkTeamPower += S[i][j];
                }
            }
        }
        int gap = Math.abs(startTeamPower - linkTeamPower);
        powerGap = Math.min(powerGap, gap);
    }
}
