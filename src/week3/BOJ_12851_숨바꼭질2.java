package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {

    private static final int MAX = 100_000;

    private static int N;
    private static int K;
    private static int[] time = new int[MAX + 1];
    private static int[] way = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 2. 시간, 경로 초기값 설정
        Arrays.fill(time, -1);
        time[N] = 0;
        way[N] = 1;
        // 3. 너비 우선 탐색
        bfs();
        // 4. K로 갈 수 있는 가장 빠른 시간과 경로 출력
        bw.write(time[K] + "\n" + way[K]);
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int position = queue.poll();
            // 각 케이스(위치 -1, +1, *2)를 검사
            for (int nextPosition : new int[]{position - 1, position + 1, position * 2}) {
                // 유효한 위치이고
                if (!isValidPosition(nextPosition)) {
                    continue;
                }
                // 방문하지 않은 위치라면 시간과 경로 수 갱신, 큐에 추가
                if (time[nextPosition] == -1) {
                    time[nextPosition] = time[position] + 1;
                    way[nextPosition] = way[position];
                    queue.offer(nextPosition);
                    continue;
                }
                // 방문했지만 동일한 경로가 존재한다면 경로 수 누적
                if (time[nextPosition] == time[position] + 1) {
                    way[nextPosition] += way[position];
                }
            }
        }
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= MAX;
    }
}
