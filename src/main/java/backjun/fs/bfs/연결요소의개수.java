package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연결요소의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int node = Integer.parseInt(str.split(" ")[0]);
        int line = Integer.parseInt(str.split(" ")[1]);
        boolean[][] visited = new boolean[node + 1][node + 1];
        boolean[] visitedNode = new boolean[node + 1];
        for (int i = 0; i < line; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int l = Integer.parseInt(s.split(" ")[1]);
            visited[n][l] = true;
            visited[l][n] = true;
        }
        int answer = 0;
        for (int i = 1; i < visited.length; i++) {
            for (int j = 1; j < visited[i].length; j++) {
                if (visited[i][j]){
                    answer++;
                    bfs(i,j,visited,visitedNode);
                    break;
                }
            }
        }
        for (int i = 1; i < visitedNode.length; i++) {
            if(!visitedNode[i]){
                answer++;
            }
        }
        bw.write(answer+"");
        bw.flush();
    }

    public static void bfs(int startNode,int startNode2, boolean[][] visited,boolean[] visitedNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visitedNode[poll] = true;
            for (int i = 1; i < visited[poll].length; i++) {
                if (visited[poll][i] && startNode != i) {
                    visited[poll][i] = false;
                    visited[i][poll] = false;
                    queue.offer(i);
                }
            }
        }
    }
}
