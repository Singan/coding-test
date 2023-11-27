package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        char[][] chars = new char[number][number];
        boolean[][] visited = new boolean[number][number];

        for (int i = 0; i < number; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                chars[i][j] = ch;
            }
        }
        int[] answer = {0,0};
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(!visited[i][j]){
                    bfs(i,j,chars,visited);
                    answer[0]++;
                }
            }
        }
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(chars[i][j]=='R')
                    chars[i][j]='G';
            }
        }
        visited = new boolean[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if(!visited[i][j]){
                    bfs(i,j,chars,visited);
                    answer[1]++;
                }
            }
        }
        System.out.println(answer[0] + " " +answer[1]);
    }
    public static void bfs(int i, int j, char[][] chars, boolean[][] visited){
        int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int [] mo:move) {
                int nextI = cur[0]+mo[0];
                int nextJ = cur[1]+mo[1];
                if(nextI<chars.length&&nextI>=0&&nextJ>=0&&
                        nextJ<chars[i].length && chars[i][j] == chars[nextI][nextJ] &&!visited[nextI][nextJ]){
                    queue.offer(new int[]{nextI,nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }

    }
}
