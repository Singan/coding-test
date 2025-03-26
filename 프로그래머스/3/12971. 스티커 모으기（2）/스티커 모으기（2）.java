class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0]; // 스티커가 1개만 있는 경우 예외 처리

        // 1️⃣ 첫 번째 스티커를 뜯는 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) { // 마지막 스티커는 선택할 수 없음
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 2️⃣ 첫 번째 스티커를 뜯지 않는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) { // 마지막 스티커 선택 가능
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]); // 두 가지 경우 중 최대값 반환
    }
}
