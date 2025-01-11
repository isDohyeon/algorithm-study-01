package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {

    private static char[][] board;
    // 8x8 보드에서 가능한 repaint의 최댓값
    private static int repaintCount = (8 * 8) / 2;
    private static int curCount;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. 보드판 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            board = new char[N][M];
            for (int y = 0; y < N; y++) {
                String line = br.readLine();
                for (int x = 0; x < M; x++) {
                    board[y][x] = line.charAt(x);
                }
            }
            // 2. 가능한 모든 시작점부터 탐색
            for (int y = 0; y <= N - 8; y++) {
                for (int x = 0; x <= M - 8; x++) {
                    // W로 시작할 경우 최솟값과
                    // B로 시작할 경우의 최솟값을 각각 계산
                    check8x8(y, x, 'W');
                    check8x8(y, x, 'B');
                }
            }
            // 4. repaint 수의 최솟값 출력
            bw.write(String.valueOf(repaintCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void check8x8(int y, int x, char firstSquare) {
        curCount = 0;
        // 3. 시작점부터 8x8 보드의 repaint 수를 계산
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char curSquare = board[y + i][x + j];
                // y의 홀짝을 검사
                // y의 홀짝 여부에 따라 같아야하는 칸과 달라야하는 칸이 상이하기 때문
                int parityNum = i % 2;
                checkSquareState(j, parityNum, curSquare, firstSquare);
            }
        }
        repaintCount = Math.min(repaintCount, curCount);
    }

    private static void checkSquareState(int j, int parityNum, char curSquare, char firstSquare) {
        // 첫 번째 사각형과 같아야 하는 칸
        if (j % 2 == parityNum) {
            // 같아야하는데 달라서 증가
            if (curSquare != firstSquare) {
                curCount++;
            }
        }
        // 첫 번째 사각형과 달라야 하는 칸
        if (j % 2 != parityNum) {
            // 달라야하는데 같아서 증가
            if (curSquare == firstSquare) {
                curCount++;
            }
        }
    }
}
