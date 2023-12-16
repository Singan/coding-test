package backjun.fs.bfs;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산 {
    static int[][] peoples;
    static boolean[] checks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wantA = sc.nextInt(); // 출력해야 할 사람
        int wantB = sc.nextInt(); // 출력해야 할 사람
        peoples = new int[n + 1][n + 1];
        checks = new boolean[n + 1];
        int count = sc.nextInt(); // 부모 자식 관계 수
        for (int i = 0; i < count; i++) {
            int people1 = sc.nextInt();
            int people2 = sc.nextInt();
            peoples[people1][people2] = 1;
            peoples[people2][people1] = 1;
        }


        bfs(wantA);
        System.out.println(peoples[wantA][wantB]==0 ? -1 :peoples[wantA][wantB]);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        checks[start] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < peoples[cur].length; i++) {
                if(peoples[cur][i] == 1 && !checks[i]){
                    queue.add(i);
                    peoples[start][i] = peoples[start][cur] +1;
                    checks[i] = true;
                }
            }
        }
    }

}
