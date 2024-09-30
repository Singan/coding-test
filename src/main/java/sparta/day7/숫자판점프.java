package sparta.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숫자판점프 {

    //https://www.acmicpc.net/problem/2210
    // 각 칸을 이동하며
    // 모든 칸에서 6칸을 합친 자리수를 set 에 담으면 될 것 같다.
    // depth 가 6이 되면 끝나도록 한다. depth = 6 에서 return 과 조건을 걸어 set 에 담도록 한다.
    // visit 을 요구하지 않는다. 즉 정말 모든 경우의 수를 다 구한다.

    static int arr[][] = new int[5][5];
    static int[][] move ={{-1,0},{0,-1},{0,1},{1,0}};

    static int[] tempArr = new int[6];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs( i, j , 0);
            }
        }
        System.out.println(set.size());
    }

    static void dfs(int i , int j,int depth){
        if(depth==6){
            StringBuilder sb = new StringBuilder();
            for (int t :tempArr){
                sb.append(t);
            }
            set.add(sb.toString());
            return;
        }
        for (int[] m:move) {
            int r = m[0] + i;
            int c = m[1] + j;
            if(0<=r && r<5 && 0<=c && c<5){
                tempArr[depth] = arr[r][c];
                dfs( r, c,depth+1);
            }
        }

    }
}
