package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

    private static int N;
    private static int[] T;
    private static int[] P;
    private static int maxProfit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N과 Ti, Pi 입력
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // 2. 모든 날부터 시작하여 가능한 모든 상담의 수를 탐색하며 최댓값 구하기
        findMaxProfit(0, maxProfit);
        // 3. 정답 출력
        bw.write(String.valueOf(maxProfit));
        bw.close();
    }

    private static void findMaxProfit(int day, int profit) {
        if (day >= N) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
        // 현재 날짜에 상담이 가능할 경우 상담 진행
        if (day + T[day] <= N) {
            // 날짜와 수익을 더하며 재귀 반복
            findMaxProfit(day + T[day], profit + P[day]);
        }
        // 현재 날짜의 다음 날짜를 검사
        findMaxProfit(day + 1, profit);
    }
}
