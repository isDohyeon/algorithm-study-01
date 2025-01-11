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
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                updateAswer(X, Y);
            }
            bw.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateAswer(int X, int Y) {
        if (X != answer && Y != answer) {
            return;
        }
        if (X == answer) {
            answer = Y;
            return;
        }
        answer = X;
    }
}
