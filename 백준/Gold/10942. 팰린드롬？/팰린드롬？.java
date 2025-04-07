import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int question = Integer.parseInt(br.readLine());

boolean dp[][] = new boolean[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n; i++) {


                int j = (len + i) - 1;
                if (j > n)
                    continue;
                if (len == 1) {
                    dp[i][j] = true;
                    continue;
                }
                if (arr[i] == arr[j]) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while (question > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end] ? 1 : 0).append("\n");
            question--;
        }
        System.out.println(sb);
    }
}
