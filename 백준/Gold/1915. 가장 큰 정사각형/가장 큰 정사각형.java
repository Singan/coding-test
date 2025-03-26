import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int board[][] = new int[n][m];
        int dp[][] = new int[n][m];
        int answer = 0;
for (int i = 0; i < n; i++) {
    String line = br.readLine();
    for (int j = 0; j < m; j++) {
        dp[i][j] = board[i][j] = line.charAt(j) - '0';
        answer = Math.max(answer, dp[i][j]); // 동시에 answer 갱신
    }
}
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer * answer);
    }
}

