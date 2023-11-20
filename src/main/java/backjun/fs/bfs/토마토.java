package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int answer = -1;
        int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] tomato = new int[n][m];
        boolean chk = true;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0 ; i < n;i++){
            for (int j = 0 ; j < m;j++){
                int to = sc.nextInt();
                tomato[i][j] = to;
                if(to==1){
                    queue.offer(new int[]{i,j,1});
                }
            }
            sc.nextLine();
        }
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int[] mo:move) {
                int x = cur[0] + mo[0];
                int y = cur[1] + mo[1];
                if(x>=0&&y>=0 && x< tomato.length&&y<tomato[0].length&&tomato[x][y]==0){
                    queue.offer(new int[]{ x,y, cur[2]+ 1 });
                    tomato[x][y] = cur[2]+ 1;
                }
            }
            answer = cur[2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0)
                    chk  = false;
            }
        }
        System.out.println(chk?answer-1:-1);
    }

}
