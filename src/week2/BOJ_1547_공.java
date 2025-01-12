package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1547_공 {

    private static int answer = 1;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. 반복 횟수 M, 컵의 번호 X, Y 입력
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                // 2. 입력받으며 공이 들어있는 컵의 번호를 갱신
                updateAnswer(X, Y);
            }
            // 3. 정답 출력
            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateAnswer(int X, int Y) {
        // 공이 들어있는 컵을 바꾸지 않았다면 아무런 갱신도 하지 않는다
        if (X != answer && Y != answer) {
            return;
        }
        // X가 공이 들어있는 컵이었다면 정답을 Y로 갱신한다
        if (X == answer) {
            answer = Y;
            return;
        }
        // Y가 공이 들어있는 컵이었다면 정답을 X로 갱신한다
        answer = X;
    }
}
