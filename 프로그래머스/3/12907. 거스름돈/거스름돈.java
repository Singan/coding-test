class Solution {

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