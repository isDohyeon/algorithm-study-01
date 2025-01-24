package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

    private static final int MAX = 100_000;

    private static int N;
    private static int K;
    private static int[] time;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, K 입력 및 시간 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[MAX + 1];
        Arrays.fill(time, -1);
        // 2. 너비 우선 탐색
        bfs();
        // 3. 결과 출력
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(N);
        time[N] = 0;

        while (!deque.isEmpty()) {
            int position = deque.poll();
            if (position == K) {
                result = time[position];
                return;
            }
            for (int nextPosition : new int[]{position - 1, position + 1, position * 2}) {
                if (!isValidPosition(nextPosition)) {
                    continue;
                }
                if (nextPosition == position * 2) {
                    time[nextPosition] = time[position];
                    deque.offerFirst(nextPosition);
                    continue;
                }
                time[nextPosition] = time[position] + 1;
                deque.offerLast(nextPosition);
            }
        }
    }

    // 위치의 유효한 범위, 방문 여부를 검사
    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= MAX && time[position] == -1;
    }
}
