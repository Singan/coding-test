package programers;

public class 연속펄스부분수열의합 {
    public static void main(String[] args) {

    }

    public long solution(int[] sequence) {


        long minusStart[] = new long[sequence.length];
        long plusStart[] = new long[sequence.length];

        minusStart[0] = sequence[0] * -1;
        plusStart[0] = sequence[0];

        long answer = Math.max(minusStart[0], plusStart[0]);

        for (int i = 1; i < sequence.length; i++) {

            int pulse1 = (i % 2 == 0) ? -1 : 1;
            int pulse2 = (i % 2 == 0) ? 1 : -1;
            minusStart[i] = Math.max(minusStart[i - 1] + (sequence[i] * pulse1),
                    (sequence[i] * pulse1)
            );
            plusStart[i] = Math.max(plusStart[i - 1] + (sequence[i] * pulse2),
                    (sequence[i] * pulse2)
            );
            answer = Math.max(answer, Math.max(minusStart[i], plusStart[i]));

        }
        return answer;
    }
}
