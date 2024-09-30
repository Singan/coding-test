package sparta.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.acmicpc.net/problem/14235
public class 크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while(n-- > 0){
            String str[] = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            if(x == 0 ) { // 명령어가 0이라면 출력
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            }else{
                for (int i = 1; i < str.length; i++) {
                    int c = Integer.parseInt(str[i]);
                    queue.add(c);
                }
            }
        }
        System.out.println(sb);
    }
}
