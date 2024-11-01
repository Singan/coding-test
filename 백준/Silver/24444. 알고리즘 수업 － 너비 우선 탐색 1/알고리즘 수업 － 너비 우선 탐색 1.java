import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] visitOrder = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (List<Integer> edges : graph) {
            Collections.sort(edges);
        }
        bfs(visited, graph, visitOrder, R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(boolean[] visited, List<List<Integer>> graph, int[] visitOrder, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        visitOrder[start] = 1;
        queue.add(start);
        int order = 2;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (Integer node : graph.get(cur)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    visitOrder[node] = order++;
                }
            }
        }

    }

}
