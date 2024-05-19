package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {


    static int n;
    static int m;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static List<Point> chicken;
    static List<Point> home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = st.countTokens();
            for (int j = 0; j < c; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (val == 0)
                    continue;

                Point p = new Point(i,j);
                if (val == 1) {
                    home.add(p);
                }
                if (val == 2) {
                    chicken.add(p);
                }
            }
        }
        visit = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int depth, int count) {

        if (count >= m) {
            int dist = 0;
            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        Point homeCur = home.get(i);
                        Point chickenCur = chicken.get(j);
                        int homeX = homeCur.x;
                        int homeY = homeCur.y;
                        int chickenX = chickenCur.x;
                        int chickenY = chickenCur.y;
                        temp = Math.min(temp , Math.abs(homeX - chickenX ) + Math.abs(homeY - chickenY));
                    }
                }
                dist += temp;
            }
            min = Math.min(min , dist);
            return;
        }

        for (int i = depth; i < chicken.size(); i++) {
            visit[i] = true;
            dfs(i + 1, count + 1);
            visit[i] = false;
        }
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}