package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp[] = new int[k + 1];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); // 무게;
            int value = Integer.parseInt(st.nextToken()); // 가치

            //dp[i]=max(dp[i],dp[i−weight]+value)
            for (int j = k; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }

        }


        // 각 0번에 물건을 담은 무게를 담는다.


        System.out.println(dp[k]);

    }
}
