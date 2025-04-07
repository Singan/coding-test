
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int end = i + T[i];
            if (end <= N + 1) {
                dp[end] = Math.max(dp[end], dp[i] + P[i]);
            }
        }
        System.out.println(dp[N + 1]);
    }
}

