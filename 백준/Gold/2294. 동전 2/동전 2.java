import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 동전의 개수
        int k = Integer.parseInt(st.nextToken());  // 목표 금액
        int INF = 1000000;  // 충분히 큰 값
        int[] dp = new int[k + 1];  // dp[i]는 i 금액을 만들기 위한 최소 동전 개수
        Arrays.fill(dp, INF);  // dp 배열 초기화
        dp[0] = 0;  // 0원을 만들기 위한 최소 동전 개수는 0

        // 동전들 입력받기
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 갱신하기
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // 동전 하나를 추가했을 때
            }
        }

        // 결과 출력
        System.out.println(dp[k] == INF ? -1 : dp[k]);  // 목표 금액을 만들 수 없으면 -1 출력
    }
}
