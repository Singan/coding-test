package sparta.day9;
// https://www.acmicpc.net/problem/7562

// 각 나이트의 이동을 모두 찾으면 될 것 같다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
//
//각 테스트 케이스는 세 줄로 이루어져 있다.
// 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. :  배열의 크기
// 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
// 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다. : 시작점 , 도착점
// 나이트가 몇 번을 움직여서 해당 위치에 도착하였는지 카운트해서 배열에 담아야 한다.
// 다음 위치에 도착할 배열에 담긴 값과 비교하여 더 작다면 바꾸고 아니라면 해당 움직임은 멈춘다.
public class 나이트의이동 {

    static int arrive[];
    static int move[][] = {{2, 1}, {2, -1}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}};

    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            visit = new boolean[l][l];
            String[] str = br.readLine().split(" ");
            int start[] = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
            str = br.readLine().split(" ");
            arrive = new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};

            if (arrive[0] != start[0] || arrive[1] != start[1]) {
                sb.append(bfs(start[0], start[1]));
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int moveCount = 0;
        queue.add(new int[]{i, j, moveCount});
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            moveCount = cur[2];

            if (visit[arrive[0]][arrive[1]]) {
                return moveCount;
            }
            for (int m[] : move) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];
                if (chk(x, y)) {
                    queue.add(new int[]{x, y, moveCount++});
                    visit[x][y] = true;
                }
            }
        }
        return moveCount;
    }


    static boolean chk(int x, int y) {
        if (x >= 0 && y >= 0 && x < visit.length && y < visit[x].length && !visit[x][y]) {
            return true;
        }
        return false;
    }
}
