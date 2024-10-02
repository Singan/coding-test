import java.util.Scanner;

//https://www.acmicpc.net/problem/2579
//계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//마지막 도착 계단은 반드시 밟아야 한다.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <stairs.length; i++) {
            dp[i] = Math.max(dp[i - 2] , stairs[i - 1] + dp[i - 3]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
