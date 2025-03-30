
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int board[][]; // 2D 배열
    static int dp[][]; // DP 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 크기 N

        board = new int[n + 1][n + 1]; // 2D 배열 초기화
        dp = new int[n + 1][n + 1]; // DP 배열 초기화

        // 입력 받기
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP를 사용하여 최장 증가 부분 수열 구하기
        int maxLength = 1;  // 최장 증가 부분 수열의 길이 (최소 1)
        
        // DP 배열 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 1; // 초기값은 1로 설정
                
                // (i, j)보다 작은 값이 있는 위치를 찾아서 LIS 길이 갱신
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        if (board[k][l] < board[i][j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }

                // 최장 LIS 길이 계산
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        // 최종 결과 출력
        System.out.println(maxLength);
    }
}
