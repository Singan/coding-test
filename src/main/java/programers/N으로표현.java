package programers;

import java.util.*;

public class N으로표현 {

    public int solution(int N, int number) {

        if (N == 1) return 1;
        int answer = 0;

        List<HashSet<Integer>> dp = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>()); // dp 배열 초기화
        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Set<Integer> set1 = dp.get(i);
                while (set1.iterator().hasNext()) {
                    int num1 = set1.iterator().next();
                    Set<Integer> set2 = dp.get(i - j);
                    while (set2.iterator().hasNext()) {
                        int num2 = set2.iterator().next();
                        dp.get(i).add(num1 + num2); // 덧셈
                        dp.get(i).add(num1 - num2); // 뺄셈
                        dp.get(i).add(num1 * num2); // 곱셈
                        if (num2 != 0) dp.get(i).add(num1 / num2); // 나눗셈
                    }
                }
            }
            if (dp.get(i).contains(number)) return i; // 찾으면 반환
        }

        return -1; // 8번 넘으면 -1 반환
    }
}
