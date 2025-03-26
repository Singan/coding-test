package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 아기상어 {

    //
    static int[][] move = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //좌우하상
    static int arr[][];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int x = Integer.parseInt(s[j]);
                if (x == 9) {
                    start[0] = i;
                    start[1] = j;
                }
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(start[0], start[1]);
    }

    public static void dfs(int startX, int startY, int stack, int size, int time) {
        visited[startX][startY] = true;
        boolean moveFlag = false;
        for (int[] m : move) {
            int newX = startX + m[0];
            int newY = startY + m[1];
            int nextSize = arr[newX][newY];
            if (newX >= 0 && newY >= 0 && newX < arr.length && newY < arr[0].length && !visited[newX][newY]
                    && nextSize <= size) {
                if (size > nextSize) {
                    stack = stack + 1;
                    arr[newX][newY] = 0;
                }
                dfs(newX, newY, arr[newX][newY] == size ? stack : stack + 1,
                        stack == size ? size + 1 : size, time + 1);
                moveFlag = true;
            }
        }
        if (!moveFlag) {
            return;
        }
        visited[startX][startY] = false;
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int size = cur[2];
            int stack = cur[3];

        }
    }
}
