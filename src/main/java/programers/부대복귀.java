package programers;

import java.util.*;

public class 부대복귀 {
    public static void main(String[] args) {
        부대복귀 solution = new 부대복귀();

        int n = 5;
        int[][] roads = {
                {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 5}
        };
        int[] sources = {1, 3, 4};
        int destination = 5;

        int[] result = solution.solution(n, roads, sources, destination);

        System.out.println("결과: " + Arrays.toString(result));
    }

    List[] roadsConnection;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        roadsConnection = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            roadsConnection[i] = new ArrayList<>();
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        for (int i = 0; i < roads.length; i++) {
            int road1 = roads[i][0];
            int road2 = roads[i][1];
            roadsConnection[road1].add(road2);
            roadsConnection[road2].add(road1);
        }

        bfs(destination, dist);
        int[] answer = new int[sources.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }

    private void bfs(int start, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> roadList = roadsConnection[cur];
            for (int j = 0; j < roadList.size(); j++) {
                int road = roadList.get(j);
                if (dist[road] == -1) {
                    queue.add(road);
                    dist[road] = dist[cur] + 1;
                }
            }
        }
    }
}
