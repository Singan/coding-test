package programers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    //연속적으로 떨어지지 않는 숫자를 모아놨다가 더 작은 숫자가 나오면 모두 pop
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] pop = stack.pop();
                answer[pop[0]] = i - pop[0];
            }
            stack.push(new int[]{i, prices[i]});
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = prices.length - pop[0] -1;
        }
        return answer;
    }
}
