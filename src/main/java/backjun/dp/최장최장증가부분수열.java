package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장최장증가부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int[] arr = new int[n * n];

        // 2D 배열을 1D 배열로 변환
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                arr[i * n + j] = board[i][j]; // 2D 배열을 1D 배열로 변환
            }
        }

        // 1D LIS 계산
        int[] dp = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            dp[i] = 1; // 최소 길이는 1 (자기 자신만 포함된 부분 수열)
        }

        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 결과 출력
        int result = 0;
        for (int i = 0; i < n * n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
