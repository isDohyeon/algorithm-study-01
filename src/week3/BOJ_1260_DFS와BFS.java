package week3;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {

    private static int N;
    private static int M;
    private static int V;

    private static List<Integer>[] graph;
    private static boolean[] visited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, M, V 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // 2. 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 3. 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        // 4. 각 정점의 인접 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        // 5. DFS 탐색
        dfs(V);
        // 6. 방문 배열 초기화 및 BFS 준비
        visited = new boolean[N + 1];
        sb.append('\n');
        // 7. BFS 탐색 시작
        bfs(V);
        // 8. 결과 출력
        System.out.print(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐 생성
        queue.offer(node); // 시작 정점 삽입
        visited[node] = true; // 시작 정점 방문 처리
        sb.append(node).append(" "); // 시작 정점 결과에 추가
        while (!queue.isEmpty()) {
            int n = queue.poll(); // 큐에서 정점 꺼내기
            // 인접한 정점 탐색
            for (int next : graph[n]) {
                if (!visited[next]) { // 방문하지 않은 정점만 탐색
                    visited[next] = true; // 방문 처리
                    sb.append(next).append(" "); // 정점 추가
                    queue.offer(next); // 큐에 추가
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true; // 현재 정점 방문 처리
        sb.append(node).append(" "); // 현재 정점 결과에 추가
        // 인접한 정점 탐색
        for (int next : graph[node]) {
            if (!visited[next]) { // 방문하지 않은 정점만 탐색
                dfs(next); // 재귀 호출로 깊이 우선 탐색 진행
            }
        }
    }
}
