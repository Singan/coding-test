import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < stones.length; i++) {
            // 덱 끝에서 현재 값보다 작은 애들은 제거 (필요 없는 값)
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            deque.offer(i);  // 현재 인덱스를 덱에 추가

            // 슬라이딩 윈도우 범위를 벗어난 값은 제거
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // k 개 이상의 윈도우가 만들어졌을 때, 최댓값을 정답 후보로 저장
            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }
        return answer;
    }
}