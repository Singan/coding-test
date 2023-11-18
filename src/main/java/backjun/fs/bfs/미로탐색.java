package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
    //N×M크기의 배열로 표현되는 미로가 있다.
    //
    //1	0	1	1	1	1
    //1	0	1	0	1	0
    //1	0	1	0	1	1
    //1	1	1	0	1	1
    //미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
    // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
    // 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
    //
    //위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
    //
    //입력
    //첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
    //
    //출력
    //첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
    static int [][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static boolean[][] check ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        check=new boolean[n][m];
        int[][] miro = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                miro[i][j] = str.charAt(j)-48;
            }
        }

        bfs(miro);
        System.out.println(miro[n-1][m-1]);
    }
    public static void bfs(int[][] miro){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        check[0][0] = true;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int[] m:move) {
                int y = cur[0] + m[0];
                int x = cur[1] + m[1];
                if(x>=0&&y>=0&&x< miro[0].length&&y< miro.length && miro[y][x]==1){
                    queue.offer(new int[]{y,x});
                    check[y][x] = true;
                    miro[y][x]=miro[y][x]+miro[cur[0]][cur[1]];
                }
            }
        }
    }
}
