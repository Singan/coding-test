package sparta.day9;
//농장에 화재가 발생했고, 소들이 화재를 끄려고 달려들고 있습니다!
//'B'라는 글자는 방금 불이 난 헛간을 나타냅니다. 'L'이라는 글자는 호수를 나타내고, 'R'은 큰 바위의 위치를 ​​나타냅니다.
//
//소들은 호수와 헛간 사이의 길을 따라 자리를 잡고 "버킷 여단"을 구성하여 길을 따라 물통을 통과시켜 화재를 진압하고자 합니다.
// 양동이는 북쪽, 남쪽, 동쪽 또는 서쪽 방향으로 바로 인접해 있는 소들 사이로 이동할 수 있습니다.
// 호수 옆에 있는 소도 마찬가지입니다. 소는 호수에 바로 인접해 있는 경우에만 호수에서 물통을 꺼낼 수 있습니다.
// 마찬가지로 소는 헛간에 바로 인접해 있는 경우에만 헛간에 물통을 던질 수 있습니다.
//성공적인 버킷 여단을 구성하기 위해 소들이 차지해야 하는 최소한의 '.' 칸 수를 결정하는 데 도움을 주세요.
//
//큰 바위가 있는 사각형에는 소를 놓을 수 없고, 헛간과 호수는 서로 바로 인접해 있지 않아야 합니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// B -> L 까지의 최소 거리의 문제 단 R 이 있다면 피해야함.
public class 버킷브릿지 {
    static int arrive[] = new int[2];
    static int start[] = new int[2];
    static int[][] track = new int[10][10];
    static boolean[][] visit = new boolean[10][10];
    static int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'R') {
                    visit[i][j] = true;
                }
                if (ch == 'B') { // 시작점
                    visit[i][j] = true;
                    start = new int[]{i, j};
                }
                if (ch == 'L') // 시작점
                    arrive = new int[]{i, j};
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            visit[cur[0]][cur[1]] = true;
            for (int[] m : move) {
                int nextX = cur[1] + m[1];
                int nextY = cur[0] + m[0];
                if (nextY >= 0 && nextY < track.length && nextX >= 0 && nextX < track[0].length
                        && !visit[nextY][nextX]) {
                    track[nextY][nextX] = track[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
        System.out.println(track[arrive[0]][arrive[1]] - 1);
    }
}