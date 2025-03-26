package programers;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {
    public static void main(String[] args) {

    }

    // 연결되는 선을 끊었을 때 몇개의 노드가 나뉘는지를 구해야함
    // 2== 노드 <-> 노드
    // 완전탐색? 재귀?
    // 완전탐색이던 재귀던 계속해서 리턴받아서 하면 될수도?
    public int solution(int n, int[][] wires) {
        int answer = -1;

        boolean[] visit = new boolean[n];

        List<Integer>[] wiresList = new List[n];

        for (int i = 0; i < n; i++) {
            wiresList[i] = new ArrayList();
        }

        for (int i = 0; i < wires.length; i++) {
            wiresList[wires[i][0]].add(wires[i][1]);
            wiresList[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wiresList.length; i++) {
            int sum = 0;
            for (int j = 0; j < wiresList[i].size(); j++) {
                int to = wiresList[i].get(j);
                while(!wiresList[to].isEmpty()) {

                }
            }
        }



        return answer;
    }
}
