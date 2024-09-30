package sparta.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 쉬운 BFS 문제
// 입력 : 노드의 개수
// 간선의 수
// 연결된 두 컴퓨터 A , B
//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7
// boolean[A][B] = true and boolean[B][A] 를 통해 연결된 것을 표기
// visit[] 을 통해 방문한 노드를 체크하여 재방문 하지 않도록 함.
// 문제는 반드시 1번 컴퓨터가 최초 감염
// queue 에 다음 목적지를 담을 때마다 count 를 올려주면 될 것이다.
public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] nodes = new boolean[n+1][n+1];
        int t = Integer.parseInt(br.readLine()); // 간선의 수
        boolean visit[] = new boolean[n+1];
        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            nodes[x][y] = true;
            nodes[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int result = 0;
        visit[1] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int i = 1; i < nodes[cur].length; i++) {
                if(nodes[cur][i] == true && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
