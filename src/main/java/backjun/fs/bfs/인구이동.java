package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
    //국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
    //위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
    //국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
    //연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
    //연합을 해체하고, 모든 국경선을 닫는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        int move[][] = {{1, 0}, {0, 1}};
        while (true) {
            boolean flag = false;
            boolean visit[][] = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    int curPopulation = arr[i][j];
//                    for (int[] m : move) {
//                        int y = m[0] + i;
//                        int x = m[1] + j;
//
//                        if (x < visit.length && x >= 0 && y < visit.length && y >= 0 && !visit[x][y]) {
//                            int population = arr[x][y];
//                            int diff = Math.abs(curPopulation - population);
//                            boolean chk = L <= diff && diff <= R;
//
//                            if (chk) {
//                                bfs(new int[]{i, j}, arr, visit, L, R);
//                                flag = true;
//                            }
//                        }
                    if (!visit[i][j]) {
                        flag = flag|bfs(new int[]{i, j}, arr, visit, L, R);
                    }
                }
            }
            if (!flag) {
                break;
            } else {
                day++;
            }

        }
        System.out.println(day);
    }

    public static boolean bfs(int[] start, int[][] arr, boolean visit[][], int l, int r) {
        int move[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        int sum = 0;
        visit[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        Queue<int[]> reQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPopulation = arr[cur[0]][cur[1]];
            reQueue.offer(cur);
            count++;
            sum += curPopulation;
            for (int[] m : move) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];

                if (x < visit.length && x >= 0 && y < visit.length && y >= 0 && !visit[x][y]) {
                    int population = arr[x][y];
                    int diff = Math.abs(curPopulation - population);
                    boolean chk = l <= diff && diff <= r;
                    if (chk) {
                        visit[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        int result = sum / count;
        boolean chk =!reQueue.isEmpty();
        while (!reQueue.isEmpty()) {
            int[] cur = reQueue.poll();
            int x = cur[0];
            int y = cur[1];
            arr[x][y] = result;
        }
        return chk;
    }
}
