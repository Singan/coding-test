package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int line = sc.nextInt();
        boolean[] check = new boolean[number+1];
        int[][] relation = new int [number+1][number+1];
        for (int i = 0 ;i<line;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            relation[n][m] = 1;
            relation[m][n] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        check[1] = true;
        int result = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0 ;i<relation[cur].length;i++){
                if(relation[cur][i]==1 && !check[i]){
                    q.offer(i);
                    check[i] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
