package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2231_분해합 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. N 입력받기
            int N = Integer.parseInt(br.readLine());
            // 1~N까지 숫자들을 생성자로써 순회
            for (int i = 1; i <= N; i++) {
                int number = i;
                int digitSum = 0;
                // 각 숫자의 분해합을 구함
                // 숫자가 양의 정수일 때
                while (number > 0) {
                    // 분해합에
                    // 숫자를 10으로 나눈 나머지인 마지막 자릿수를 더하고
                    digitSum += number % 10;
                    // 숫자를 10으로 나누어 다음 반복 때 다음 자리 수를 구할 수 있게 한다.
                    number /= 10;
                }
                // 생성자와 분해합의 합이 N과 같다면
                if (i + digitSum == N) {
                    // 결과를 출력하고 프로그램을 종료
                    bw.write(String.valueOf(i));
                    return;
                }
            }
            // N까지의 모든 숫자를 탐색했는데도 생성자를 찾지 못했다면
            // 0을 출력
            bw.write(String.valueOf(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
