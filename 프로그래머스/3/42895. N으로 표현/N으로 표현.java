import java.util.*;

class Solution {
   public int solution(int N, int number) {
        if (N == number) return 1; // N 자체가 number이면 1 리턴

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N을 i번 연속 사용한 값 추가 (5, 55, 555, ...)
        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);
        }

        // DP 시작
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }
            // 목표 숫자가 포함되면 최소 횟수 반환
            if (dp.get(i).contains(number)) return i;
        }

        return -1; // 8번 초과하여 만들 수 없으면 -1
    }
}