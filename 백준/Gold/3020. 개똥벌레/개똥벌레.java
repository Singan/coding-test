import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 장애물 개수
        int H = Integer.parseInt(st.nextToken()); // 동굴의 높이

        int[] bottom = new int[H + 1]; // 석순 (아래에서 올라옴)
        int[] top = new int[H + 1];    // 종유석 (위에서 내려옴)

        // 입력 받기
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            if (i % 2 == 0) bottom[size]++;
            else top[size]++;
        }

        // **누적합 계산 (bottom은 위로, top은 아래로)**
        for (int i = H - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        // **각 높이에서의 장애물 개수 계산**
        int minObstacles = Integer.MAX_VALUE;
        int count = 0;
        
        int[] obstacles = new int[H + 1];

        for (int h = 1; h <= H; h++) {
            obstacles[h] = bottom[h] + top[H - h + 1];

            if (obstacles[h] < minObstacles) {
                minObstacles = obstacles[h];
                count = 1;
            } else if (obstacles[h] == minObstacles) {
                count++;
            }
        }

        // 최솟값과 해당하는 구간 개수 출력
        System.out.println(minObstacles + " " + count);
    }
}
