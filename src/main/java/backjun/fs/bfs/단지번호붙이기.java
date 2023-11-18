package backjun.fs.bfs;

import java.util.*;

public class 단지번호붙이기 {

    static boolean[][] chk;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] houseArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        houseArr = new int[n][n];
        sc.nextLine();
        chk = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                houseArr[i][j] = str.charAt(j) - 48;
            }
        }
        int result = 0;
        List<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < houseArr[i].length; j++) {
                if (houseArr[i][j] == 1 && !chk[i][j]) {
                    result++;
                    q.add(bfs(i,j));
                }
            }
        }
        Collections.sort(q);
        System.out.println(result);
        q.stream().forEach(integer -> System.out.println(integer));
    }

    public static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int countHouse = 0;
        chk[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            countHouse++;
            for (int[] m : move) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];
                if (x >= 0 && y >= 0 && x < houseArr.length && y < houseArr[i].length && !chk[x][y] && houseArr[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    chk[x][y] = true;
                }
            }
        }
        return countHouse;
    }
}
