
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 가장 긴 오름차순 수열을 찾으면 된다.
//https://www.acmicpc.net/problem/1965
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int cur = Integer.parseInt(str[i]);
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                int prev = Integer.parseInt(str[j]);
                if (prev < cur) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 다른 수열의 값이 더 클 수 있기에 MAX 사용
                }
            }
        }

        // dp 배열 중에서 가장 큰 값 찾기
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }
}
