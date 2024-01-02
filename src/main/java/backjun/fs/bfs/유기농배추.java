package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 유기농배추 {
    //2
    //10 8 17
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCase; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int bachu = sc.nextInt();
            sc.nextLine();
            int[][] grid = new int[y][x];
            boolean visited[][] = new boolean[y][x];
            for (int j = 0; j < bachu; j++) {
                int width = sc.nextInt();
                int height = sc.nextInt();
                grid[height][width] = 1;//높이 너비
            }
            System.out.println(test(grid, visited));
        }
    }

    public static int test(int[][] grid, boolean[][] visited) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) { // 높이
            for (int j = 0; j < grid[i].length; j++) { // 너비
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return result;
    }

    public static void bfs(int[][] grid, boolean[][] visited, int i, int j) { // i 높이 j 너비
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Stack<int[]> queue = new Stack<>();
        queue.push(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.pop();
            for (int[] m : move) {
                int y = cur[0] + m[0];
                int x = cur[1] + m[1];
                if (x >= 0 && y >= 0 && y < grid.length && x < grid[i].length && !visited[y][x] && grid[y][x] == 1) {
                    queue.push(new int[]{y, x});
                    visited[y][x] = true;
                }
            }
        }
    }
}
