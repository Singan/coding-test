import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 회원 수
        boolean[][] friendRelation = new boolean[n + 1][n + 1]; // 친구 관계
        int one, two;
        int scores[] = new int[n + 1]; // 각 회원의 점수

        // 친구 관계 입력
        while (true) {
            String strArr[] = br.readLine().split(" ");
            one = Integer.parseInt(strArr[0]);
            two = Integer.parseInt(strArr[1]);

            if (one == -1) {
                break;
            }
            friendRelation[one][two] = true;
            friendRelation[two][one] = true;
        }

        // 각 회원에 대해 BFS 실행
        for (int i = 1; i <= n; i++) {
            scores[i] = bfs(i, friendRelation, n);
        }

        // 최소 점수 구하기
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minScore = Math.min(minScore, scores[i]);
        }

        // 최소 점수를 가진 회원들 출력
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                sb.append(i).append(" ");
                count++;
            }
        }

        // 결과 출력
        System.out.println(minScore + " " + count);
        System.out.println(sb.toString().trim());
    }

    // BFS를 통해 각 회원의 점수를 계산하는 함수
    static int bfs(int me, boolean[][] friendRelation, int n) {
        Queue<int[]> queue = new LinkedList<>(); // [노드, 거리]
        boolean[] visit = new boolean[n + 1]; // 방문 여부 체크
        queue.add(new int[]{me, 0});
        visit[me] = true;

        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currentNode = cur[0];
            int distance = cur[1];

            // 가장 먼 거리를 찾는다
            maxDistance = Math.max(maxDistance, distance);

            // 친구 관계 탐색
            for (int i = 1; i <= n; i++) {
                if (friendRelation[currentNode][i] && !visit[i]) {
                    queue.add(new int[]{i, distance + 1});
                    visit[i] = true;
                }
            }
        }

        return maxDistance; // 가장 멀리 있는 친구까지의 거리가 점수
    }
}
