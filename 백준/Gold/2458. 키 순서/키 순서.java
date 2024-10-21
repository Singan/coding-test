import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]); // 사람의 수 (배열의 크기)
        int m = Integer.parseInt(str[1]); // 키의 비교 횟수 (br 반복문)

        boolean[][] arr = new boolean[n + 1][n + 1]; // 키 비교 정보를 저장할 배열

        // 키 비교 정보 입력
        for (int i = 0; i < m; i++) {
            String[] stringArr = br.readLine().split(" ");
            int a = Integer.parseInt(stringArr[0]);
            int b = Integer.parseInt(stringArr[1]);
            arr[a][b] = true; // a가 b보다 키가 작다
        }

        // 각 사람마다 BFS를 통해 자신의 키가 비교 가능한 사람들을 확인
        boolean[][] chk = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            chk[i] = bfs(i, arr);
        }

        // 위상관계를 상호 반영
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (chk[i][j]) {
                    chk[j][i] = true; // 상위 관계를 반영
                }
            }
        }

        // 모든 사람과의 키 비교가 가능한 사람을 카운트
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && !chk[i][j] && !chk[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    // BFS를 통해 각 사람의 키 비교 관계를 탐색하는 함수
    static boolean[] bfs(int me, boolean[][] arr) {
        Queue<Integer> queue = new LinkedList<>(); // 탐색을 위한 큐
        boolean[] visit = new boolean[arr.length]; // 방문 여부 체크 배열
        visit[me] = true; // 자기 자신은 탐색하지 않음
        queue.add(me);

        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 현재 노드

            // 연결된 노드를 탐색
            for (int i = 1; i < arr.length; i++) {
                if (arr[cur][i] && !visit[i]) { // cur보다 키가 작은 사람 탐색
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        return visit;
    }
}
