import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            arr = new int[n][n];
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            System.out.println("Problem " + x + ": " + dijkstra(0, 0, n, dist));
            x++;
        }
    }

    static int dijkstra(int startX, int startY, int n, int[][] dist) {

        int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        boolean[][] visit = new boolean[n][n];
        queue.add(new int[]{arr[startX][startY], startX, startY});


        dist[startX][startY] = arr[startX][startY];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curCost = cur[0];  // 현재까지의 비용
            int curX = cur[1];
            int curY = cur[2];

            // 이미 방문한 노드라면 무시
            if (visit[curX][curY]) continue;

            visit[curX][curY] = true;

            for (int m[] : move) {
                int nextX = cur[1] + m[0];
                int nextY = cur[2] + m[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                int nextCost = curCost + arr[nextX][nextY];
                // 더 적은 비용으로 갈 수 있으면 갱신
                if (nextCost < dist[nextX][nextY]) {
                    dist[nextX][nextY] = nextCost;
                    queue.add(new int[]{nextCost, nextX, nextY});  // 새롭게 큐에 추가
                }

            }
        }
        // 도착점의 최소 비용 반환

        return dist[n - 1][n - 1];
    }
}