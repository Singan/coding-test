package programers;

import java.util.Map;

public class 타일링 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4));
    }
    static class Solution {
        public long solution(int n) {
            long[] dp = new long[n+1];
            int mod = 1000000007;
            dp[0] = 1;
            dp[2] = 3;
            for(int i=4; i<=n; i+=2){
                dp[i] = (dp[i-2]*4%mod -dp[i-4]%mod +mod)%mod;
            }
            return dp[n];
        }
    }
}
