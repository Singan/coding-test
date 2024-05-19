package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM {
    //자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는
    // 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    //
    //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        visit = new boolean[n];
        arr = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == m){
            for (int value : arr){
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {

            if(!visit[i]){
                visit[i] = true;

                arr[depth] = i+1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
