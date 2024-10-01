import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697
// n->k 가 되기 위한 가장 빠른 경로
// 0 ≤ N ≤ 100,000
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 누나
        int k = Integer.parseInt(st.nextToken()); // 동생
        boolean[] visit = new boolean[100001];


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visit[n] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();



            int a = cur[0] + 1; // 앞으로 한칸
            int b = cur[0] - 1 >= 0 ? cur[0] - 1 : 0; // 뒤로 한칸
            int c = cur[0] * 2; // 순간이동
            if(cur[0] == k ) {
                System.out.println(cur[1]);
                break;
            }
            if (a <= visit.length - 1 && !visit[a]) {
                visit[a] = true;
                queue.add(new int[]{a, cur[1] + 1});
            }
            if (b >= 0 && !visit[b]) {
                visit[b] = true;
                queue.add(new int[]{b, cur[1] + 1});
            }
            if (c <= visit.length - 1 && !visit[c]) {
                visit[c] = true;
                queue.add(new int[]{c, cur[1] + 1});
            }
        }
    }
}
