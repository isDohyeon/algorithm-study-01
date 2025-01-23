package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

    private static int N;
    private static int M;
    private static int K;

    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 2. 가로, 세로, 배추 개수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            // 3. 배추 위치 입력, 지도에 표시
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            // 4. 배추밭 탐색
            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    // 방문하지 않은 배추에 대 BFS로 연결된 배추 탐색 후 카운트 증가
                    if (!visited[y][x] && map[y][x] == 1) {
                        bfs(y, x);
                        count++;
                    }
                }
            }
            // 5. 결과 저장 후 카운트 초기화
            bw.write(count + "\n");
        }
        bw.close();
    }

    // 너비 우선 탐색 메서드
    private static void bfs(int b, int a) {
        Queue<int[]> queue = new LinkedList<>();
        visited[b][a] = true;
        queue.offer(new int[]{b, a});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValidCoord(ny, nx)) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    // 유효한 좌표 검증 메서드
    private static boolean isValidCoord(int ny, int nx) {
        return nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 1 && !visited[ny][nx];
    }
}
