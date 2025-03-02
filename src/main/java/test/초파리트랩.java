package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 초파리트랩 {

    // 트랩은 십자 모양 즉 상하좌우
    // 초파리의 활동 범위는 3*3
    static int pari[][];
    static int grid[][];
    static boolean visit[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int d = Integer.parseInt(split[1]);
        pari = new int[n][n];
        grid = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if(Integer.parseInt(line[j]) == 1)
                    visit[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    check(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pari[i][j]);
            }
            System.out.println();
        }
    }

    public static void check(int i, int j) {
        int move[][] = {{-1, 0, 1}, {-1, 0, 1}};
        pari[i][j] = 1;
        int x = i;
        int y = j;
        for (int m = 0; i < move.length; i++) {
            int nx = x + move[0][m];
            for (int k = 0; k < move[m].length; k++) {
                int ny = y + move[1][k];
                if(nx < 0 || ny < 0 || nx >= pari.length || ny >= pari[0].length) {
                    break;
                }
                pari[nx][ny]++;
            }
        }
    }
}
