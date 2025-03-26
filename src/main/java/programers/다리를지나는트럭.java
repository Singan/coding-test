package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < bridge_length - 1; i++) {
            queue.add(0);
        }
        for (int i = 0; i < truck_weights.length; i++) {

            if (sum + truck_weights[i] <= weight && queue.size() < bridge_length) {
                sum += truck_weights[i];
                queue.add(i);
            } else {
                queue.remove();
            }
        }
        return answer;
    }
}
