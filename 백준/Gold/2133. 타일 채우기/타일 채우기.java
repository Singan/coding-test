import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if(n<2){
            System.out.println(0);
            System.exit(0);
            }
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;


        for (int i = 4; i <= n; i++) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }
        System.out.println(dp[n]);
    }
}
