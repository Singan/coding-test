package backjun.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 연속합2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[][] = new int[n][2];
        int arr[] = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        dp[0][1] = 0; // 숫자를 삭제했을 경우
        dp[0][0] = arr[0]; // 숫자를 선택했을 경우

        int maxSum = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i] , arr[i]);
            // 이전 수열을 포함했을 경우 vs 현재부터 수열을 다시 시작하는 경우
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i] ,dp[i - 1][0]);
            // 이전 수열의 모든 값을 더한 값 vs 하나를 뺀 수열의 값 + 현재 의 값
            maxSum = Math.max(dp[i][0],Math.max(dp[i][1] , maxSum));
        }
        System.out.println(maxSum);

    }
}
