package backjun.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합분해 {

    // k 가 3이라 할 때 3을 만든다면
    // 첫 숫자가 1이라면 2개로 1을 만드는 경우의 수를 더한다.
    // 그 후 1개로 2를 만드는 경우의 수를 더한다.


    //
    // 즉 첫 숫자를(j) i(목표숫자)에서 빼고
    // 나머지 숫자의 [k] 배열을 확인하면 나머지 숫자를 만드는 경우의 수의 개수를 더하기에 나온다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int dp[][] = new int[n + 1][k + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= k; j++) {
                // 만약 5개의 숫자를 쓸 수 있다면 2 - 1 + 2 니까 이게 이해가 안간다.
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }
        System.out.println(dp[n][k]);


    }
}
