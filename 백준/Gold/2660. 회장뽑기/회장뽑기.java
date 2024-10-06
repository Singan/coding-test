
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/2660
// bfs 를 통해 다음 노드를 탐색할 때마다 값을 1 올린다.
// 모든 노드의 탐색을 해야 할 것 같다.
// 문제는 총점이 아니라 큰 값이 하나라도 있다면 그 사람의 점수는 큰 값이다.
// 점수는 작은 사람이 회장이 된다.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] friendRelation = new boolean[n + 1][n + 1];
        int one = 0, two = 0;
        int scores[] = new int[n + 1];
        StringBuilder sb = new StringBuilder();

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
        for (int i = 1; i < friendRelation.length; i++) {
            scores[i] = bfs(i, friendRelation);
        }
        // 최소 점수 구하기

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minScore = Math.min(minScore, scores[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                sb.append(i).append(" ");
                count++;
            }
        }
        System.out.println(minScore + " " + count);
        System.out.println(sb);
    }

    static int bfs(int me, boolean[][] friendRelation) {
        Queue<int[]> queue = new LinkedList<>(); // 다음 노드의 위치와 몇 번째인지를 카운트
        boolean visit[] = new boolean[friendRelation.length]; // 이미 친구인 친구를 다시 탐색하지 않도록
        visit[me] = true; // 본인 탐색은 막는다.
        queue.add(new int[]{me, 0});
        int maxScore = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            maxScore = Math.max(maxScore , cur[1]);
            for (int i = 1; i < friendRelation.length; i++) {
                if (friendRelation[cur[0]][i] && !visit[i]) {
                    queue.add(new int[]{i, cur[1] + 1});
                    visit[i] = true;
                }
            }

        }
        return maxScore;
    }
}
