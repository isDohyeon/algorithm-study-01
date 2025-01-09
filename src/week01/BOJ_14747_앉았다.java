package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14747_앉았다 {

    public static void main(String[] args) {
        double winCount = 0;
        double total = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 1. 카드 입력받기
            int card1 = Integer.parseInt(st.nextToken());
            int card2 = Integer.parseInt(st.nextToken());
            // 2. 같음 여부, 합 계산
            boolean isPlayerSame = isSame(card1, card2);
            int playerSum = calculateSum(card1, card2, isPlayerSame);
            // 3. 입력받은 카드(=플레이어가 뽑은 카드)를 전체 카드에서 지우기
            List<Integer> totalCards = getRemovedCards(card1, card2);
            // 4. 남아있는 모든 카드 조합을 탐색하며 승리를 계산
            for (int i = 0; i < totalCards.size(); i++) {
                for (int j = i + 1; j < totalCards.size(); j++) {
                    int enemyCard1 = totalCards.get(i);
                    int enemyCard2 = totalCards.get(j);
                    boolean isEnemySame = isSame(enemyCard1, enemyCard2);
                    int enemySum = calculateSum(enemyCard1, enemyCard2, isEnemySame);
                    if (isWin(playerSum, isPlayerSame, enemySum, isEnemySame)) {
                        winCount++;
                    }
                    total++;
                }
            }
            // 5. 승리 횟수 / 전체 시도횟수 = 승률
            bw.write(String.format("%.3f", winCount / total));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWin(double playerSum, boolean isPlayerSame, double enemySum, boolean enemySame) {
        if (isPlayerSame && !enemySame) {
            return true;
        }
        if (!isPlayerSame && enemySame) {
            return false;
        }
        return playerSum > enemySum;
    }

    private static List<Integer> getRemovedCards(int card1, int card2) {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i == card1 && i == card2) {
                continue;
            }
            cards.add(i);

            if (i == card1 || i == card2) {
                continue;
            }
            cards.add(i);
        }
        return cards;
    }

    private static boolean isSame(double card1, double card2) {
        return card1 == card2;
    }

    private static int calculateSum(int card1, int card2, boolean isSame) {
        if (isSame) {
            return card1;
        }
        return (card1 + card2) % 10;
    }
}
