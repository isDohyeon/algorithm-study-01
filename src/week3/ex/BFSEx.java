package week3.ex;

import java.util.*;

public class BFSEx {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        // 예제 그래프 초기화 (0번 노드 사용 안 함)
        graph = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 추가
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(6);

        // 방문 배열 초기화
        visited = new boolean[7];

        // BFS 실행
        System.out.println("BFS 탐색 결과");
        bfs(1);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true; // 시작 노드 방문 처리
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // 인접 노드 탐색
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // 방문 처리
                    queue.add(neighbor); // 큐에 추가
                }
            }
        }
    }
}
