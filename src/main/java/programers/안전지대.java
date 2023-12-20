package programers;

import java.util.*;

public class 안전지대 {
    public static void main(String[] args) {
        int a = new Solution().solution(new int[][]{
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1}}
        );
        System.out.println("정답 " + a);
    }

    private static class Solution {
        public int solution(int[][] board) {
            int answer = 0;

            int count = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        count += bfs(i, j, board);
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.printf("%2d ", board[i][j]);
                }
                System.out.println();
            }
            System.out.println("카운트" + count);
            return board.length * board.length - count;
        }
    }

    public static int bfs(int i, int j, int[][] board) {
        int count = 0;
        int[][] move = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1},
                {-1, 1}, {-1, -1}, {-1, 0}, {0, -1}};
        Queue<int[]> qu = new LinkedList();
        qu.offer(new int[]{i, j});
        board[i][j] = 3;
        count++;
        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            for (int[] m : move) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];
                if (x >= 0 && x < board.length && y < board[i].length && y >= 0 && board[x][y] < 2) {
                    if (board[x][y] == 1) {
                        qu.add(new int[]{x, y});
                    }
                    board[x][y] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
