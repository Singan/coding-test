class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] minusStart = new long[n];
        long[] plusStart = new long[n];

        // 첫 번째 값 초기화
        minusStart[0] = sequence[0] * -1;
        plusStart[0] = sequence[0];

        long answer = Math.max(minusStart[0], plusStart[0]);

        // DP (카데인 알고리즘 적용)
        for (int i = 1; i < n; i++) {
            int pulse1 = (i % 2 == 0) ? -1 : 1;
            int pulse2 = (i % 2 == 0) ? 1 : -1;

            minusStart[i] = Math.max(minusStart[i - 1] + (sequence[i] * pulse1), sequence[i] * pulse1);
            plusStart[i] = Math.max(plusStart[i - 1] + (sequence[i] * pulse2), sequence[i] * pulse2);

            answer = Math.max(answer, Math.max(minusStart[i], plusStart[i]));
        }

        return answer;
    }
}
