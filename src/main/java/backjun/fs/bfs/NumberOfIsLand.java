package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsLand {
    static int[][] checking ={{-1,0},{0,-1},{0,1},{1,0}};


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int m, n;
        m = grid.length;//Y 길이 측정
        n = grid[0].length; //X 길이 측정
        boolean[][] visited = new boolean[m][n];


        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1&&!visited[i][j]){ // 배열의 y,x 가 1이고 아직 방문하지 않은 노드일 때 그 섬에 처음 발을 내딛는 것임
                    result++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        System.out.println(result);
    }
    public static void bfs(int[][]grid,int i,int j,boolean[][] visited){
        visited[i][j]=true;//처음 내딛은 땅에 트루로 체크
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});//큐에 밟는 땅 마다 담아줌
        while (!queue.isEmpty()){
            int[] cur = queue.poll(); //현재 위치를 꺼냄
            for (int[] chk:checking) {
                int x = cur[0]+chk[0];//현재 위치에서 상하좌우를 찾아야함
                int y = cur[1]+chk[1];//현재 위치에서 상하좌우를 찾아야함
                if(x>=0&&y>=0 && x<grid.length&&y<grid[j].length &&!visited[x][y] && grid[x][y] == 1){
                    visited[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }
}
