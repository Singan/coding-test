package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {

    // 맨하튼 거리를 이용하여야 한다.
    // 현재 위치에서 맨하튼 거리 상 위치한 편의점 또는 도착점이 있는지 탐색해야 한다.
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        final int TEST_CASE = Integer.parseInt(br.readLine());
        for (int i = 0; i < TEST_CASE; i++) {
            String result = test();
            System.out.println(result);
        }
    }

    public static String test() throws Exception {
        final int n = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n + 1];
        Point[] node = new Point[n + 1];
        Point start = createPoint();
        for (int i = 0; i < n + 1; i++) {
            Point point = createPoint();
            node[i] = point;
        }

        boolean flag = false;
        for (int i = 0; i < node.length; i++) {
            if (start.manhattan(node[i]) <= 1000 && !visit[i]) {
                flag = bfs(visit, node[i], node);
                visit[i] = true;
            }
            if (flag) {
                return "happy";
            }
        }

        return "sad";
    }

    public static Point createPoint() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        return new Point(x, y);
    }

    public static boolean bfs(boolean[] visit, Point point, Point[] node) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < node.length; i++) {
                if (cur.manhattan(node[i]) <= 1000 && !visit[i]) {
                    if (i == node.length - 1) {
                        return true;
                    }
                    queue.add(node[i]);
                    visit[i] = true;
                }
            }
        }
        return false;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int manhattan(Point point) {
        return Math.abs(point.x - this.x) + Math.abs(point.y - this.y);
    }
}