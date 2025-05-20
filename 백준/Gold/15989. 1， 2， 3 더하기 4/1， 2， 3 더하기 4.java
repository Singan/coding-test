
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            arr[i] = n;
            max = Math.max(n, max);
        }


        int dp[] = new int[max + 1];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= max; j++) {
                dp[j] += dp[j - i];
            }
        }


        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
