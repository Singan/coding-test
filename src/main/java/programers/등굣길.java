package programers;

public class 등굣길 {

    public static void main(String[] args) {

    }

    public static int solution(int m, int n, int[][] puddles) {

        int board[][] = new int[m + 1][n + 1];
        final int MOD = 1_000_000_007;
        for (int i = 0; i < puddles.length; i++) {
            int[] arr = puddles[i];
            board[arr[0]][arr[1]] = -1;
        }
        board[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else {
                    if (i > 1)
                        board[i][j] = (board[i - 1][j] + board[i][j]) % MOD;

                    if (j > 1)
                        board[i][j] = (board[i][j - 1] + board[i][j]) % MOD;
                }
            }
        }

        return board[m][n];
    }
}
