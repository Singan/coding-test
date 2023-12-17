package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
    //첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt()*-1;
        int max = 10000001;
        int[] visited = new int[F+1];
        for (int i = 0; i <visited.length ; i++) {
            visited[i] = 10000001;
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[S] = 0;
        queue.add(new int[]{S,0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int floor = cur[0];
            int count = cur[1];

            if(floor==G){
                break;
            }
            int curU = floor+U;
            int curD = floor+D;
            if(curU<=F&& visited[curU] > count+1){
                queue.add(new int[]{curU,count+1});
                visited[curU] = count+1;
            }
            if(curD>0&&visited[curD] > count+1){
                queue.add(new int[]{curD,count+1});
                visited[curD] = count+1;
            }
        }
        System.out.println(visited[G] != max?visited[G] : "use the stairs");
    }
}
