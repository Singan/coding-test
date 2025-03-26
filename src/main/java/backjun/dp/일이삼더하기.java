package backjun.dp;

import java.util.Scanner;

public class 일이삼더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println(1);
                continue;
            } else if (n == 2) {
                System.out.println(2);
                continue;
            } else if (n == 3) {
                System.out.println(4);
                continue;
            }
            int dp[] = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
