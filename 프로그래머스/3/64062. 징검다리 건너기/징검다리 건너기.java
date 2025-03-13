import java.util.*;

class Solution {
 public int solution(int[] stones, int k) {
        // Deque를 사용하여 슬라이딩 윈도우에서 최댓값을 추적
        Deque<Integer> deque = new LinkedList<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            // 이전 값들이 현재 윈도우에 포함되지 않으면 제거
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 현재 값은 현재 윈도우 내에서 최댓값을 유지해야 하므로
            // 덱의 뒤에서부터 값을 제거
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            // 현재 인덱스를 덱에 추가
            deque.offerLast(i);

            // 윈도우 크기 k가 되면, 최소 최댓값을 구한다.
            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }

        return answer;
    }
}