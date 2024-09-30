package sparta.day6;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.acmicpc.net/problem/1927
// 입력 : N (명령어 실행 횟수) 와 0 또는 자연수이다. 0이면 우선순위 큐에서 poll 을 통해 출력 자연수라면 add 만약 비어있다면 0을 출력
// 로직 : 그냥 우선순위 큐를 쓰면 될 것 같다. 비어있을 때만 체크한다.
// 출력 : 0 의 수 만큼 출력 비어있을 때는 0을 출력
public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0 ) { // 명령어가 0이라면 출력
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            }else{
                queue.offer(x); // 아니라면 큐에 추가.
            }
        }
        System.out.println(sb);
    }
}
