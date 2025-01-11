package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10448_유레카이론 {

    private static final int MAX_OF_NUM = 1000;
    private static List<Integer> triangleSeq;

    public static void main(String[] args) {
        // 1. 최대 테스트 수를 넘지 않는 삼각수들을 계산
        triangleSeq = calculateTriangleNumbers();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 2. 수를 입력받으며 세 삼각수의 합으로 나타낼 수 있는지를 검사
            int N = Integer.parseInt(br.readLine());
            int[] answers = new int[N];
            for (int i = 0; i < N; i++) {
                int number = Integer.parseInt(br.readLine());
                // 3. 나타낼 수 있다면 1, 없다면 0으로 정답 저장
                if (isSumOfThreeTriangleNumbers(number)) {
                    answers[i] = 1;
                    continue;
                }
                answers[i] = 0;
            }

            // 4. 정답 출력
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(answers[i]));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 삼각수의 수열을 계산하여 리스트로 반환
     * 삼각수는 n번째 삼각수에 대해 (n * (n + 1)) / 2로 계산
     *
     * @return 계산된 삼각수 리스트
     */
    private static List<Integer> calculateTriangleNumbers() {
        List<Integer> seq = new ArrayList<>();
        int num;
        int n = 0;
        while (true) {
            n++;
            num = (n * (n + 1)) / 2;
            if (num >= MAX_OF_NUM) {
                break;
            }
            seq.add(num);
        }
        return seq;
    }

    /**
     * 주어진 수가 세 개의 삼각수로 표현될 수 있는지를 확인
     *
     * @param number 확인할 숫자
     * @return 세 개의 삼각수 합으로 표현 가능하면 true, 불가능하면 false
     */
    private static boolean isSumOfThreeTriangleNumbers(int number) {
        int size = triangleSeq.size();
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                for (int l = 0; l < size; l++) {
                    if (triangleSeq.get(j) + triangleSeq.get(k) + triangleSeq.get(l) == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
