package programers;

import java.util.*;

public class 가장먼노드 {
    class Solution {

        //1번 노드부터 시작
        //최단 거리로 이동했을 때 가장 노드를 많이 거치는 수
        public int solution(int n, int[][] edge) {
            int nodeCount = n;
            boolean[][] vertex = new boolean[n + 1][n + 1];
            int[] move = new int[n + 1];
            boolean[] nodeCheck = new boolean[n + 1];
            int answer = 0;
            for (int i = 0; i < edge.length; i++) {
                vertex[edge[i][0]][edge[i][1]] = true;
                vertex[edge[i][1]][edge[i][0]] = true;
            }

            Queue<Integer> queue = new LinkedList();
            queue.offer(1);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int h = 0; h < vertex[cur].length; h++) {
                    if (vertex[cur][h] & !nodeCheck[h]) {
                        queue.offer(h);
                        nodeCheck[h] = true;
                        move[h] = move[cur] + 1;
                        vertex[cur][h] = false;
                        vertex[h][cur] = false;
                    }
                }
            }
            int max = 0;
            for (int i = 1; i < move.length; i++) {
                max = Math.max(max, move[i]);
            }
            for (int i = 1; i < move.length; i++) {
                if (max == move[i]) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
