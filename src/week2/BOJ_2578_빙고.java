package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {

    private static int[][] bingoBoard = new int[5][5];
    private static int bingoCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 1. 빙고판 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingoBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2. 사회자가 부르는 수 입력
        int numberCount = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                // 빙고 카운트와 숫자 카운트 갱신
                bingoCount = 0;
                numberCount++;
                int number = Integer.parseInt(st.nextToken());
                // 입력받은 수를 빙고판에서 지움(0으로 변경)
                removeNumber(number);
                // 가로, 세로, 대각선의 빙고 수를 검사
                checkBingo();
                // 3. 빙고 수가 3이 되면 현재까지의 카운트를 출력하고 종료
                if (bingoCount >= 3) {
                    bw.write(String.valueOf(numberCount));
                    bw.close();
                    return;
                }
            }
        }
    }

    private static void checkBingo() {
        // 가로 검사
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingoBoard[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            updateBingoCount(isBingo);
        }
        // 세로 검사
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingoBoard[j][i] != 0) {
                    isBingo = false;
                    break;
                }
            }
            updateBingoCount(isBingo);
        }
        // 우하향 대각선 검사
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingoBoard[i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        updateBingoCount(isBingo);
        isBingo = true;
        // 좌상향 대각선 검사
        for (int i = 0; i < 5; i++) {
            if (bingoBoard[i][4 - i] != 0) {
                isBingo = false;
                break;
            }
        }
        updateBingoCount(isBingo);
    }

    private static void updateBingoCount(boolean isBingo) {
        if (isBingo) {
            bingoCount++;
        }
    }

    private static void removeNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingoBoard[i][j] == number) {
                    bingoBoard[i][j] = 0;
                    return;
                }
            }
        }
    }
}
