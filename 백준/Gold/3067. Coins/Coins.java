
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 동전의 가지 수
            int N = Integer.parseInt(br.readLine());

            // 동전의 금액들
            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            // 목표 금액
            int M = Integer.parseInt(br.readLine());

            // 여기서 coins 배열과 M을 가지고 문제 풀이 함수 호출 가능
            int result = calc(M, coins);
            System.out.println(result);
        }

    }

    public static int calc(int M, int[] coins) {
        int dp[] = new int[M + 1];

        dp[0] = 1;
        for (int coin : coins){
            for (int i = coin; i <=M; i++) {
                dp[i] += dp[i - coin];
            }
        }


        return dp[M];
    }
}
