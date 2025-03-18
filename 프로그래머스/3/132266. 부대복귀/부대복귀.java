
import java.util.*;


public class Solution {


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
