
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        int start = Integer.parseInt(str[1]);

        arr = new int[n][n];

        // 2차원 배열 초기화
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘 수행
        floydWarshall();

        // 백트래킹으로 모든 행성 방문
        visited = new boolean[n];
        visited[start] = true;
        backtrack(start, 0, 1);

        // 결과 출력
        System.out.println(minCost);
    }

    static void floydWarshall() {
        // 플로이드-워셜 알고리즘
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }

    static void backtrack(int current, int cost, int visitedCount) {
        if (visitedCount == n) {
            // 모든 행성을 방문했을 때 최소 비용 업데이트
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                backtrack(i, cost + arr[current][i], visitedCount + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
