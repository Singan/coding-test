package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB거리2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(s[j]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            int[][] dp = new int[n][3];
            for (int i = 0; i < 3; i++) {
                if (i == color) {
                    dp[0][i] = cost[0][i];
                } else {
                    dp[0][i] = 100001;
                    // 문제의 조건 1번집과 N번 집의 색은 달라야 하기에 첫 집의 색을 고정하고 DP를 돌리기 위해
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                // i 번에 빨간색을 칠한다면 이전 색과 달라야 함 그러니 빨간색(0) 외의 두 DP의 값과 비교하고 이전은 빨강색이라 가정
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                // 이렇게 이전 색 모두를 고려하여 DP 배열을 채운다.
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i == color) {
                    continue;
                }
                result = Math.min(result, dp[n - 1][i]);
            }
        }
        System.out.println(result);
    }
}
