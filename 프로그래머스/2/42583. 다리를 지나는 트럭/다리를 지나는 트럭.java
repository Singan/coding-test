import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0; // 경과 시간
        int bridgeWeight = 0; // 다리 위 트럭 총 무게

        for (int truck : truck_weights) {
            while (true) {
                // 다리가 꽉 찼으면 먼저 트럭 빼기
                if (bridge.size() == bridge_length) {
                    bridgeWeight -= bridge.poll();
                }

                // 다리에 트럭을 올릴 수 있으면 추가
                if (bridgeWeight + truck <= weight) {
                    bridge.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                } 
                // 다리에 트럭을 올릴 수 없으면 0(빈 자리) 추가하면서 시간 경과
                else {
                    bridge.add(0);
                    time++;
                }
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        return time + bridge_length;
    }
}