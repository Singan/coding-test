import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
    // 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
    // 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
    // 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토,
    // 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
    //
    //토마토가 하나 이상 있는 경우만 입력으로 주어진다.
    //    6 4
    //    0 0 0 0 0 0
    //    0 0 0 0 0 0
    //    0 0 0 0 0 0
    //    0 0 0 0 0 1
    static int M, N, H;
    static int[][][] box; // 3차원 배열
    static boolean[][][] visited;
    static int[][] directions = {
            {-1, 0, 0}, // 위
            {1, 0, 0}, // 아래
            {0, -1, 0}, // 앞
            {0, 1, 0}, // 뒤
            {0, 0, -1}, // 왼쪽
            {0, 0, 1}  // 오른쪽
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이(층)

        box = new int[H][N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        // 입력 받기 (z -> y -> x)
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }

                }
            }
        }
        if(queue.size() == H * N * M) {
            System.out.println(0);
            return;
        }
        while (!queue.isEmpty()) {
            int[] boxLocation = queue.poll();

            int prevh = boxLocation[0];
            int prevn = boxLocation[1];
            int prevm = boxLocation[2];
            for (int[] direction : directions) {
                int h = boxLocation[0] + direction[0];
                int n = boxLocation[1] + direction[1];
                int m = boxLocation[2] + direction[2];

                if (h >= 0 && n >= 0 && m >= 0 && h < H && n < N && m < M
                        && box[h][n][m] == 0) {  // 0인 곳만 방문 가능
                    box[h][n][m] = box[prevh][prevn][prevm] + 1;
                    queue.add(new int[]{h, n, m});
                }
            }
        }
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(box[h][n][m]  , max);
                }
            }
        }
        System.out.println(max - 1);
    }
}