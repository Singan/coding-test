package programers;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class 징검다리건너기 {

    public static void main(String[] args) {


    }

    public int solution(int[] stones, int k) {
        // K 구간의 돌 중 가장 큰 돌이 가장 작은 구간의 가장 큰 돌이 정답

        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < stones.length; i++) {
            //1 3 2 3 7 3 10 k=3
            // 1 -> 0
            // 3 -> 1
            // 2 -> 1,2 i:2
            // 3 -> 1,3 i:3
            // 7 -> peekFirst + k = 4 i = 4로 1 제거
            // 그 후 7보다 작은 3 제거 이로써 queue에 남은 값 4
            while (!deque.isEmpty() && deque.peekFirst() + k <= i) { // 윈도우의 범위를 벗어남
                deque.pollFirst();
            }

            while (!deque.isEmpty() && stones[i] > stones[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if(i >= k - 1){
                answer = Math.min(answer,stones[deque.peekFirst()]);
            }

        }
        return answer;
    }
}
