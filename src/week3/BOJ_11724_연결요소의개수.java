package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 정점과 간선의 갯수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 그래프 초기화
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 3. 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        // 4. 연결 요소 개수 계산
        int connectedComponents = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponents++;
            }
        }
        // 5. 결과 출력
        bw.write(String.valueOf(connectedComponents));
        bw.close();
    }

    private static void dfs(int node) {
        // 현재 정점 방문 처리
        visited[node] = true;
        // 인접한 정점 탐색
        for (int next : graph[node]) {
            if (!visited[next]) { // 방문하지 않은 정점만 탐색
                dfs(next); // 재귀 호출로 깊이 우선 탐색
            }
        }
    }
}
