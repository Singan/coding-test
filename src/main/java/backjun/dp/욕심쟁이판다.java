package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 욕심쟁이판다 {
    static int board[][];

    static int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(str[j]);
                board[i][j] = value;
            }
        }


        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j]; // 이미 계산된 값이면 반환

        dp[i][j] = 1; // 최소한 자기 자신에서 1칸 이동 가능
        for (int[] m : move) {
            int x = i + m[0];
            int y = j + m[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[i][j] < board[x][y]) {
                dp[i][j] = Math.max(dp[i][j], dfs(x, y) + 1);
            }
        }

        return dp[i][j];
    }
}
