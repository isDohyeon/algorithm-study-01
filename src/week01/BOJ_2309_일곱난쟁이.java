package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {

    private static final int N = 9;
    private static int[] tall;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            tall = new int[N];
            int sum = 0;
            // 1. 키 입력받으며 키의 총 합을 구함
            for (int i = 0; i < N; i++) {
                int length = Integer.parseInt(br.readLine());
                tall[i] = length;
                sum += length;
            }
            // 2. 키를 오름차순 정렬
            Arrays.sort(tall);
            // 3. 2명이 빠진 모든 키의 합를 검사
            for (int i = 0; i < N - 1; i++) {
                for (int j = 1; j < N; j++) {
                    if (findImposter(sum, i, j, bw)) {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean findImposter(int sum, int i, int j, BufferedWriter bw) throws IOException {
        // 키의 총합 - 두 키의 합 == 100이라면
        // -> 진짜 난쟁이 7명을 찾은 것
        if ((sum - (tall[i] + tall[j])) == 100) {
            printDwarfs(i, j, bw);
            return true;
        }
        return false;
    }

    private static void printDwarfs(int i, int j, BufferedWriter bw) throws IOException {
        // 임포스터 난쟁이 두 명 빼고 모두 출력
        for (int k = 0; k < N; k++) {
            if (k == i || k == j) {
                continue;
            }
            bw.write(String.valueOf(tall[k]));
            bw.newLine();
        }
        bw.flush();
    }
}
