package sparta.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1번 움직여서 자두를 받는다면
// 이는 0번 움직인 것에 +1 을 한 값이다.
// 하지만 0번 움직인 것이 이전에 1번 움직인 것보다 값이 작다면 1번 움직인 값을 그대로 사용한다.
public class 자두나무 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int T = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);

        int arr[] = new int[T + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][][] dp = new int[2][T + 1][W + 1]; //
        for (int i = 1; i <= T; i++) {
            int cur = arr[i];
            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    dp[0][i][j] = dp[0][i - 1][j] + (cur % 2);
                    continue;
                }
                // 자두가 1번 나무에서 떨어질 때
                dp[1][i][j] = dp[1][i - 1][j];
                dp[0][i][j] = dp[0][i - 1][j];
                if (cur == 1) {
                    dp[0][i][j] = Math.max(dp[0][i][j], dp[1][i - 1][j - 1]); // 이전 나무에서 움직이지 않았을 때와 움직였을 때 중 큰 값으로 덮어씌운다.
                    dp[0][i][j]++;
                }
                // 자두가 2번 나무에서 떨어질 때
                else {
                    dp[1][i][j] = Math.max( dp[1][i][j], dp[0][i - 1][j - 1]);
                    dp[1][i][j]++;
                }
            }
        }
        int ans = Math.max(dp[0][T][W], dp[1][T][W]); // 1번에서 끝나는 최대 움직인 횟수와 2번에서 끝나는 최대 움직인 횟수를 비교한다.
        System.out.println(ans);

    }
}
