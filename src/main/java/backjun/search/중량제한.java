package backjun.search;

import java.io.*;
import java.util.*;

public class 중량제한 {

    static int N, M, start, end;
    static List<int[]>[] bridges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridges = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            bridges[i] = new ArrayList<>();
        }
        int left = 1;
        int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bridges[a].add(new int[]{b, c});
            bridges[b].add(new int[]{a, c});

            right = Math.max(c, right);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean chk = bfs(mid);

            if(chk){
                left = mid + 1;
                answer = Math.max(mid , answer);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean bfs(int weight) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] nextNode : bridges[curr]){

                if (!visited[nextNode[0]] && nextNode[1] >= weight){
                    if (nextNode[0] == end) return true;
                    queue.add(nextNode[0]);
                    visited[nextNode[0]] = true;
                }

            }
        }
        return false;
    }
}
