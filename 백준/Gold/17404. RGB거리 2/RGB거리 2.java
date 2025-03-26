import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }

        // 첫 번째 집을 각각 R, G, B로 칠하는 경우의 최소 비용을 구함
        int result = Integer.MAX_VALUE;
        
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];

            // 첫 번째 집의 색을 고정하고, 다른 색은 불가능한 큰 값으로 설정
            for (int color = 0; color < 3; color++) {
                if (color == firstColor) dp[0][color] = cost[0][color];
                else dp[0][color] = 1000 * 1000; // 충분히 큰 값
            }

            // DP 수행
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            // 마지막 집의 색이 첫 번째 집과 같으면 제외하고 최소값 갱신
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    result = Math.min(result, dp[n - 1][lastColor]);
                }
            }
        }

        System.out.println(result);
    }
}
