package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

    private static int N;
    private static int[] A;
    private static final List<Character> operators = new ArrayList<>();
    private static final char[] operator = {'+', '-', '*', '/'};

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        // Ai 입력
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int opNums = Integer.parseInt(st.nextToken());
            for (int j = 0; j < opNums; j++) {
                operators.add(operator[i]);
            }
        }
        // 2. 재귀 탐색 시작
        findAnswer(A[0], 1);
        // 4. 정답 출력
        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void findAnswer(int number, int depth) {
        // 3. 깊이가 N과 같아지면 최대, 최솟값 갱신 후 종료
        if (depth == N) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        // 재귀를 통해 모든 경우의 수 탐색
        for (int i = 0; i < operators.size(); i++) {
            // 사용할 연산자
            char operator = operators.remove(i);
            // 현재 숫자 계산 후 다음 반복
            findAnswer(calculateNextNumber(number, A[depth], operator), depth + 1);
            // 다른 경우 탐색을 위한 연산자 복구
            operators.add(i, operator);
        }
    }

    private static int calculateNextNumber(int num1, int num2, char operator) {
        switch (operator) {
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            case '*' :
                return num1 * num2;
            case '/' :
                return num1 / num2;
        }
        return 0;
    }
}
