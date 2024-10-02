import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/11055
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");


        int dp[] = new int[n];
        dp[0] = Integer.parseInt(str[0]);
        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(str[i]);
            dp[i] = value;
            for (int j = i - 1; j >= 0; j--) {
                int prev = Integer.parseInt(str[j]);
                if (prev < value) {
                    //10
                    //1 100 2 50 60 3 5 6 7 8
                    dp[i] = Math.max(dp[j] + value , dp[i]);
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
