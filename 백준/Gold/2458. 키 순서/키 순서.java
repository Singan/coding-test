
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/2458
//모든 노드와 연결된 노드를 찾는 문제
// 단방향으로 구현해야 상위 노드에서 하위 노드로 갔다가 다시 상위 노드로 가는 상황이 안나온다.
// 대신 상위 노드에서 하위 노드 탐색 시 하위노드에 상위 노드를 체크해줘야 한다.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]); //사람의 수 (배열의 크기)
        int m = Integer.parseInt(str[1]); // 키의 비교 횟수 (br 반복문)

        boolean[][] arr = new boolean[n + 1][n + 1];
        boolean[][] chk = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String stringArr[] = br.readLine().split(" ");
            int a = Integer.parseInt(stringArr[0]);
            int b = Integer.parseInt(stringArr[1]);
            arr[a][b] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            chk[i] = bfs(i, arr);
        }
        for (int i = 0; i <chk.length ; i++) {
            for (int j = 0; j < chk.length ; j++) {
                if(chk[i][j]){
                    chk[j][i] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < chk.length; i++) {
            boolean flag = true;
            for (int j = 1; j < chk.length; j++) {
                if(!chk[i][j])
                    flag = false;
            }
            if(flag)
                count++;
        }
        System.out.println(count);
    }

    static boolean[] bfs(int me, boolean[][] arr) {
        Queue<Integer> queue = new LinkedList<>(); // 다음 노드의 위치와 몇 번째인지를 카운트
        boolean visit[] = new boolean[arr.length]; // 이미 친구인 친구를 다시 탐색하지 않도록
        visit[me] = true; // 본인 탐색은 막는다.
        queue.add(me);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i < arr.length; i++) {
                if (arr[cur][i] && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }

        }
        return visit;
    }
}
