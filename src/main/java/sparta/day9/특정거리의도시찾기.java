package sparta.day9;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
// 둘째 줄부터 M 개의 줄 A번 도시에서 B번

// 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
public class 특정거리의도시찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < m; i++) { // 도로가 연결된 세팅
            String str[] = br.readLine().split(" ");
            int cur = Integer.parseInt(str[0]);
            nodes[cur].roads.add(Integer.parseInt(str[1]));
        }

        Queue<Node> q = new LinkedList<>();

        nodes[x].visit = true;
        q.add(nodes[x]);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i : cur.roads) {
                if (!nodes[i].visit) {
                    q.add(nodes[i]);
                    nodes[i].visit = true;
                    nodes[i].count = cur.count + 1;
                    if(nodes[i].count == k)
                        sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb.length()==0 ? -1 : sb);
    }

    static class Node {
        boolean visit = false;
        List<Integer> roads = new ArrayList();
        int count = 0;
    }
}

