import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        boolean[] visited = new boolean[N + 1];
        int[] visitOrder = new int[N + 1]; // 각 정점의 방문 순서를 기록할 배열
        List<List<Integer>> graph = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 각 정점의 인접 정점을 오름차순으로 정렬
        for (List<Integer> edges : graph) {
            Collections.sort(edges);
        }

        bfs(visited, graph, visitOrder, R);

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    static void bfs(boolean[] visited, List<List<Integer>> graph, int[] visitOrder, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        visitOrder[start] = 1; // 시작 정점의 방문 순서

        int order = 2; // 다음 방문 순서

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graph.get(cur)) { // 인접 리스트에서 인접 정점 순회
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    visitOrder[neighbor] = order++; // 방문 순서 기록
                    queue.add(neighbor);
                }
            }
        }

        // 방문하지 않은 정점은 0으로 설정
        for (int i = 1; i < visitOrder.length; i++) {
            if (visitOrder[i] == 0) {
                visitOrder[i] = 0; // 기본적으로 이미 0으로 초기화됨
            }
        }
    }
}
