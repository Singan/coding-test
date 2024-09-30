package sparta.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의이동2 {
    static boolean[][] visit;
    static Queue<int[]> queue;
    static int width = 0;
    static int move[][] = {{2, 1}, {2, -1}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(sc.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (caseCount >= 1) {
            width = Integer.parseInt(sc.readLine());

            visit = new boolean[width][width];
            queue = new LinkedList<>();
            String str;
            str = sc.readLine();
            int x = Integer.parseInt(str.split(" ")[0]);
            int y = Integer.parseInt(str.split(" ")[1]);


            str = sc.readLine();
            int nowX = Integer.parseInt(str.split(" ")[0]);
            int nowY = Integer.parseInt(str.split(" ")[1]);
            int moveCount = 0;
            queue.add(new int[]{nowX,nowY,moveCount});
            while (!queue.isEmpty()) {

                int[] z = queue.poll();
                nowX = z[0];
                nowY = z[1];
                moveCount = z[2];

                if (nowX == x && nowY == y) {
                    stringBuilder.append(moveCount + "\n");
                    break;
                }
                moveCount += 1;
                for (int m[] : move) {
                    int zx = nowX + m[0];
                    int zy = nowY + m[1];

                    move(zx, zy, moveCount);

                }
            }
            caseCount--;
        }
        System.out.println(stringBuilder);
    }

    public static void move(int xcase, int ycase, int move) {

        if (!(ycase < width && xcase < width && xcase >= 0 && ycase >= 0))
            return;
        if (!visit[xcase][ycase]) {
            int[] graph = new int[3];
            visit[xcase][ycase] = true;
            graph[0] = xcase;
            graph[1] = ycase;
            graph[2] = move;
            queue.add(graph);
        }
    }
}

