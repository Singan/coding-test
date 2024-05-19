package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M2 {
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
        dfs(0 , 0);

        System.out.println(sb);
    }

    public static void dfs(int depth , int startNo) {
        if (depth == m) {
            for (int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = startNo; i < n; i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1 , i);
                visit[i] = false;
            }
        }

    }
}
