package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1051_숫자정사각형 {

    private static int[][] rectangle;
    private static int size;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. 정사각형 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            rectangle = new int[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    rectangle[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
            // 2. 면 크기를 줄여가며 네 점의 숫자가 같은 정사각형 찾기
            size = Math.min(N, M);
            while (size > 1) {
                if (findSquare(N, M)) {
                    break;
                }
                size--;
            }
            // 3. 넓이를 정답으로 출력
            bw.write(String.valueOf(size * size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean findSquare(int N, int M) {
        // 면의 크기로 인덱스를 계산하여 네 점을 검사
        for (int i = 0; i <= N - size; i++) {
            for (int j = 0; j <= M - size; j++) {
                int sizeIndex = size - 1;
                int topLeft = rectangle[i][j];
                int topRight = rectangle[i][j + sizeIndex];
                int bottomLeft = rectangle[i + sizeIndex][j];
                int bottomRight = rectangle[i + sizeIndex][j + sizeIndex];
                if (isSamePoints(topLeft, topRight, bottomLeft, bottomRight)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSamePoints(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        return topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight;
    }
}
