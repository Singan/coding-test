package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int INF = 1000000; // 충분히 큰 값
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        int coins[] = new int[n];
        int[] coinsCount = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            coins[i] = value;
            dp[value] = 1;
            coinsCount[i]++;
        }

        for (int coin : coins) {
//            for (int c = 1; c <= coinsCount[coin]; c++) {
//                for (int i = coin; i <= k; i++) {
//                    if (coin * c <= k)
//                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }

                for (int i = coin; i <= k; i++) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
        }
        System.out.println(dp[k]);
    }
}
