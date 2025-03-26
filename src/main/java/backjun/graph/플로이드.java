package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 플로이드 {
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
        for (int k = 1; k <= n; k++) {  // 경유지 k
            for (int i = 1; i <= n; i++) {  // 출발지 i
                for (int j = 1; j <= n; j++) {  // 도착지 j
                    if (arr[i][k] < inf || arr[k][j] < inf) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
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
