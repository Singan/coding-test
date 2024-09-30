package sparta.day6;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

//입력 : 사람의 수 , 센티의 키 , 뿅망치 사용 횟수
// 그 외 거인의 키가 각 줄로 들어온다. 즉 거인의 수만큼 for 문
// 문제 : 하지만 마법의 뿅망치는 횟수 제한이 있다.
// 그래서 센티는 마법의 뿅망치를 효율적으로 사용하기 위한 전략을 수립했다.
// 바로 매번 가장 키가 큰 거인 가운데 하나를 때리는 것이다.
// 센티보다 키가 작도록 해야함 (==X)
// 로직 : 우선순위 큐로 가장 큰 값을 꺼내 나누고 다시 집어넣는다. 이를 뿅망치 횟수만큼 반복
// 만약 pop 했을 때 이미 센티의 키보다 작은 값이 나온다면 break 를 건다.
// 출력 : peek 으로 값을 꺼냈을 때 센티의 키보다 작은 값이 나온다면 YES이다
public class 센티와마법의뿅망치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));


        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 거인의 수
        int cm = Integer.parseInt(str[1]);// 센티의 키
        int hammer = Integer.parseInt(str[2]); // 뿅망치 사용 횟수
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int count = 0; // 뿅망치를 사용한 횟수
        for (int i = 0; i < hammer; i++) {
            if ((queue.peek() < cm) || (queue.peek() == 1))
                break;
            // 뿅망치 사용 중 센티보다 작은 값이 나온다는 것은 큐에서 더 큰 값이 없다는 것이기에 더이상 센티보다 큰 사람이 없다.
            // 1은 나누지 못한다는 문제에 맞춰 가장 큰 값이 1이면 더이상 나눌 수 없음으로 나가도록 한다.

            int giant = queue.poll();
            queue.add(giant/2);
            count++;
        }
        if(queue.peek()<cm){ // 큐의 첫 번째 값이 cm보다 작다면 모든 값이 작은 것임으로 YES 아니라면 NO
            System.out.println("YES");
            System.out.println(count);
        }else{
            System.out.println("NO");
            System.out.println(queue.peek());
        }

    }
}
