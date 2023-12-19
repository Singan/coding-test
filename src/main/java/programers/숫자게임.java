package programers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숫자게임 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5,1,3,7},new int[]{2,2,6,8}));
    }
    private static class Solution {
        public int solution(int[] A, int[] B) {
            Queue<Integer> queue1 = new PriorityQueue<>();
            Queue<Integer> queue2 = new PriorityQueue<>();
            for (int i = 0; i < B.length; i++) {
                queue1.add(A[i]);
                queue2.add(B[i]);
            }
            int count = 0;
            while (!queue2.isEmpty()){
                int a = queue1.peek();
                int b = queue2.poll();
                if(a<b){
                    count++;
                    queue1.remove();
                }
            }
            return count;
        }
    }
}
