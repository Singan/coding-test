
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {

            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());
            int dp[][] = new int[floor][ho + 1];
            dp[0][1] = 1;
            for (int i = 2; i < dp[0].length; i++) {
                dp[0][i] = dp[0][i - 1] + i;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[floor - 1][ho]);
        }
    }
}
