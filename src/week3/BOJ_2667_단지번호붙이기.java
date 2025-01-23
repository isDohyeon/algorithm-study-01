package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ_2667_단지번호붙이기 {

    private static int N;

    private static char[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int count;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, 지도 입력
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // 2. 지도 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 집을 발견하면
                if (!visited[i][j] && map[i][j] == '1') {
                    // dfs 탐색
                    dfs(i, j);
                    // 집의 개수를 결과 리스트에 저장 후 카운트 초기화
                    result.add(count);
                    count = 0;
                }
            }
        }
        // 3. 결과 리스트 오름차순 정렬
        result.sort(Comparator.naturalOrder());
        // 4. 결과 출력
        bw.write(result.size() + "\n");
        for (Integer groupSize : result) {
            bw.write(groupSize + "\n");
        }
        bw.close();
    }

    private static void dfs(int y, int x) {
        // 현재 집을 방문처리
        visited[y][x] = true;
        count++;
        // 상하좌우를 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValidHome(ny, nx)) {
                dfs(ny, nx);
            }
        }
    }

    private static boolean isValidHome(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == '1' && !visited[ny][nx];
    }
}

