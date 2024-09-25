package sparta.day5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//
public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문제는 K 만큼 pop 을 하고 마지막 수를 출력하고 나머지는 다시 큐에 되돌리면 되는 간단한 문제지만
        // 남은 수의 개수가 K보다 작을 때가 고민되었다.
        // 왜냐면 마지막 문자열엔 , 을 안찍기때문이다. 이를 가장 효율적인 방법이 있을까
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() > 1) {
            int cur = queue.poll();
            count++;
            if (count == K) {
                sb.append(cur).append(", ");
                count = 0;
            } else {
                queue.add(cur);
            }
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
