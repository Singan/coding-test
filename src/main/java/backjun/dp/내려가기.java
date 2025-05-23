package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][3];
        int arr[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0] = arr[0];
        int max , min;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0] , Math.max(dp[i - 1][1] , dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.max(dp[i - 1][2] , dp[i - 1][1]) + arr[i][2];
        }
        max = Math.max(dp[n - 1][0] , Math.max(dp[n - 1][1] , dp[n - 1][2]));
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] , dp[i - 1][1]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0] , Math.min(dp[i - 1][1] , dp[i - 1][2])) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][2] , dp[i - 1][1]) + arr[i][2];
        }

        min = Math.min(dp[n - 1][0] , Math.min(dp[n - 1][1] , dp[n - 1][2]));
        System.out.println(max + " " + min);
    }
}
