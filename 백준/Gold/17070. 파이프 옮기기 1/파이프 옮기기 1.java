
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int dp[][][] = new int[n][n][3];

        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (board[i][j] != 0)
                    continue;


                // 가로 파이프가 될 수 있는 방법
                // 가로방향에서 진행되어왔을 경우

                if (board[i][j - 1] == 0) {
                    dp[i][j][0] += dp[i][j - 1][0];
                    dp[i][j][0] += dp[i][j - 1][2];
                }

                if(i == 0)
                    continue;

                // 세로
                if (board[i - 1][j] == 0) {
                    dp[i][j][1] += dp[i - 1][j][1];
                    dp[i][j][1] += dp[i - 1][j][2];
                }
                // 대각 방향에서 왔을 경우
                if (board[i][j - 1] == 0 && board[i - 1][j] == 0 && board[i - 1][j - 1] == 0){
                    dp[i][j][2] += dp[i - 1][j - 1][0];
                    dp[i][j][2] += dp[i - 1][j - 1][1];
                    dp[i][j][2] += dp[i - 1][j - 1][2];
                }
            }
        }
        int result = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(result);
    }
}
