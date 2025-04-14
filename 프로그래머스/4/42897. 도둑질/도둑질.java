class Solution {
    public int solution(int[] money) {
        if (money.length == 1) return money[0];  // 하나만 있을 경우
        
        // 첫 집을 털지 않은 경우, 마지막 집을 털지 않은 경우로 나누어서 계산
        int answer1 = robRange(money, 0, money.length - 2);  // 첫 집을 포함하지 않는 경우
        int answer2 = robRange(money, 1, money.length - 1);  // 마지막 집을 포함하지 않는 경우

        return Math.max(answer1, answer2);
    }

    // 주어진 범위에서 가장 많은 돈을 훔칠 수 있는 값 계산
    public int robRange(int[] money, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + money[i]);
            prev2 = temp;
        }

        return prev1;
    }
}
