package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크 {
    static int[][] arr;
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    public static void dfs(int prev , int depth ) {
        if (depth == n / 2) {
            int teamStart = 0;
            int teamLink = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visit[i] == true && visit[j] == true) {
                        teamStart += arr[i][j];
                        teamStart += arr[j][i];
                    }
                    else if (visit[i] == false && visit[j] == false) {
                        teamLink += arr[i][j];
                        teamLink += arr[j][i];
                    }
                }
            }
            int val = Math.abs(teamStart - teamLink);

            if (val == 0) {
                System.out.println(val);
                System.exit(0);
            }
            min = Math.min(min, val);
            return;
        }

        for (int i = prev; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i+1, depth+1);
                visit[i] = false;
            }
        }
    }
}
