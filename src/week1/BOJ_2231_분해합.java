package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231_분해합 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (find()) {
            return;
        }

        System.out.println(0);
    }

    private static boolean find() {
        for (int i = 1; i <= N; i++) {
            int num = i;
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == N) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
}
