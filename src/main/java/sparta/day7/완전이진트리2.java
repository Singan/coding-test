package sparta.day7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 완전이진트리2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 트리의 층 수 입력
        String[] str = br.readLine().split(" ");  // 트리 노드들 입력

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, str.length - 1});  // 시작과 끝 인덱스를 큐에 넣음
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        while (!queue.isEmpty() && depth < n) {
            int size = queue.size();  // 현재 층에 있는 노드의 개수

            for (int i = 0; i < size; i++) {
                int[] range = queue.poll();  // 큐에서 범위를 꺼냄
                int start = range[0];
                int end = range[1];

                if (start > end) continue;  // 유효하지 않은 범위는 패스

                int mid = (start + end) / 2;  // 중앙값 계산
                sb.append(str[mid] + " ");  // 현재 층의 노드 출력

                // 왼쪽과 오른쪽 서브트리의 범위를 큐에 넣음
                queue.offer(new int[]{start, mid - 1});
                queue.offer(new int[]{mid + 1, end});
            }
            sb.append("\n");
            depth++;  // 층 깊이 증가
        }
        System.out.println(sb);
    }
}

