package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20546_기적의매매법 {

    // 주가의 상승과 하락의 스트릭을 기록하는 변수
    private static int risingStreak = 0;
    private static int fallingStreak = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. 현금 입력
            int cash = Integer.parseInt(br.readLine());
            // 2. 준현, 성민 객체 생성
            Trader junhyeon = new Trader(cash);
            Trader seongmin = new Trader(cash);
            // 3. 주가 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 첫 날엔 전날의 주가가 없기 때문에 초기값 -1
            int lastDayStock = -1;
            for (int day = 0; day < 14; day++) {
                int todayStock = Integer.parseInt(st.nextToken());
                // 전날의 주가가 존재할 경우에만 스트릭을 갱신
                // 첫 날은 스트릭 계산에 포함하지 않는다
                if (lastDayStock != -1) {
                    updateStreak(todayStock, lastDayStock);
                }
                // 주식 매도, 매수 처리
                handleTrade(todayStock, junhyeon, seongmin);
                // 주가의 상승or하락 비교를 위한 전날 주가 갱신
                lastDayStock = todayStock;
            }
            int jhAssets = junhyeon.getTotalAssets(lastDayStock);
            int smAssets = seongmin.getTotalAssets(lastDayStock);
            bw.write(configWinner(jhAssets, smAssets));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateStreak(int todayStock, int lastDayStock) {
        if (todayStock > lastDayStock) {
            risingStreak++;
            fallingStreak = 0;
            return;
        }
        if (todayStock < lastDayStock) {
            fallingStreak++;
            risingStreak = 0;
        }
    }

    private static String configWinner(int jhAssets, int smAssets) {
        if (jhAssets > smAssets) {
            return "BNP";
        }
        if (jhAssets < smAssets) {
            return "TIMING";
        }
        return "SAMESAME";
    }

    private static void handleTrade(int stockValue, Trader junhyeon, Trader seongmin) {
        if (junhyeon.getCash() >= stockValue) {
            junhyeon.buy(stockValue);
        }
        if (fallingStreak >= 3 && seongmin.getCash() >= stockValue) {
            seongmin.buy(stockValue);
        }
        if (risingStreak >= 3) {
            seongmin.sell(stockValue);
        }
    }
}

class Trader {

    private int cash;
    private int shares;

    public Trader(int cash) {
        this.cash = cash;
        this.shares = 0;
    }

    // 주식의 매수 - 보유 현금 감소, 갯수 증가
    public void buy(int stockValue) {
        int buyAmount = cash / stockValue;
        cash -= buyAmount * stockValue;
        shares += buyAmount;
    }

    // 주식의 매도 - 보유 현금 증가, 갯수 감소
    public void sell(int stockValue) {
        cash += shares * stockValue;
        shares = 0;
    }

    public int getCash() {
        return cash;
    }

    // 총 자산 - 보유 현금 + 주식 갯수 x 주가
    public int getTotalAssets(int stockValue) {
        return cash + (shares * stockValue);
    }
}
