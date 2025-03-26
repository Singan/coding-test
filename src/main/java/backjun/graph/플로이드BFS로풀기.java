package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 플로이드BFS로풀기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 버스의 수
        int inf = 1000000;
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(arr[i], inf);
            arr[i][i] = 0;  // 자기 자신으로 가는 비용은 0
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end] = Math.min(arr[start][end], cost);
        }

        // BFS로 최단 경로 탐색 및 비용 갱신
        for (int i = 1; i <= n; i++) {
            int[] visitedCost = new int[n + 1]; // 방문 배열 (중복 방지)
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, 0}); // 시작 노드 삽입
            Arrays.fill(visitedCost, 1000000);   // 초기값 설정
            visitedCost[i] = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curIndex = cur[0];
                int curCost = cur[1];

                for (int j = 1; j <= n; j++) {
                    if (arr[curIndex][j] < inf) {
                        int newCost = curCost + arr[curIndex][j];
                        if (visitedCost[j] > newCost) {  // 유효 경로 & 미방문 노드
                            visitedCost[j] = Math.min(visitedCost[j], newCost);
                            q.add(new int[]{j, newCost}); // 큐에 삽입
                        }
                    }
                }
            }
            for (int j = 1; j <= n; j++) {
                arr[i][j] = visitedCost[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append((arr[i][j] == inf ? 0 : arr[i][j])).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
