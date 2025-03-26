package programers;

public class 거스름돈 {

    public static void main(String[] args) {
        거스름돈 sold = new 거스름돈();
        int answer = sold.solution(5 , new int[]{1,2,5});
        System.out.println(" answer = " + answer);
    }

    public int solution(int n, int[] money) {


        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (final int m : money) {
            for (int i = m; i<= n; i++) {
                dp[i] += dp[i-m];
            }
        }
        int answer = dp[n];
        return answer;
    }
}
