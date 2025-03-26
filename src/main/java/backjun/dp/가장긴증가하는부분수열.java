package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    //6
    //10 20 10 30 20 50

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        System.out.println(dp[0]);
    }
}
