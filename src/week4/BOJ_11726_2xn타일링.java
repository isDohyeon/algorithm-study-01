package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11726_2xn타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = getResult(N);

        bw.write(String.valueOf(result));
        bw.close();
    }

    private static int getResult(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }
        return dp[N];
    }
}
