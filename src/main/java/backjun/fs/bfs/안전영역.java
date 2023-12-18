package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
    //재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다. 먼저 어떤 지역의 높이 정보를 파악한다.
    // 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다. 이때, 문제를 간단하게 하기 위하여,
    // 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
    //
    //어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
    //    // 예를 들어, 다음은 N=5인 지역의 높이 정보이다.
    //
    //     6	8	2	6	2
    //     3	2	3	4	6
    //     6	7	3	3	2
    //     7	2	5	3	6
    //     8	9	5	2	7
    //이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자. 이 경우에 물에 잠기는 지점을 회색으로 표시하면 다음과 같다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        int max = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            String[] numberStr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(numberStr[j]);
                max = Math.max(max, number);
                min = Math.min(min, number);
                arr[i][j] = number;
            }
        }
        int result = 1;
        for (int i = min; i <= max; i++) {
//            for (int k = 0; k < n; k++) {
//                for (int j = 0; j < n; j++) {
//
//                }
//            }
            result = Math.max(result, bfs(arr, i, n));
        }
        System.out.println(result);
    }

    public static int bfs(int[][] arr, int k, int n) {
        int count = 0;
        boolean vis[][] = new boolean[n][n];
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[i].length; j++) {
                if (arr[i][j]>k && !vis[i][j]) {
                    count++;
                    bfsWhiling(i, j,arr, vis,k);
                }
            }
        }
        return count;
    }

    public static void bfsWhiling(int i, int j, int[][] arr, boolean vis[][],int k) {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{i, j});
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] m : move) {
                int row = cur[0] + m[0];
                int col = cur[1] + m[1];
                if (row < vis.length && col < vis.length && row >= 0 && col >= 0 && arr[row][col]>k && !vis[row][col]) {
                    queue.add(new int[]{row, col});
                    vis[row][col] = true;
                }
            }
        }
    }
}
