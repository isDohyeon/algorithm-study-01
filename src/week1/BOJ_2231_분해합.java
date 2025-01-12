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
            int N = Integer.parseInt(br.readLine());
            for (int number = 1; number <= N; number++) {
                int sum = 0;
                while (number > 0) {
                    sum += number % 10;
                    number /= 10;
                }
                if (number + sum == N) {
                    bw.write(String.valueOf(number));
                    return;
                }
            }
            bw.write(String.valueOf(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
