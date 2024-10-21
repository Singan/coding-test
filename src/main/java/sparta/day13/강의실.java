package sparta.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//가장 빠른 강의로 정렬한다.
//2 : 14
//3 : 8
//6 : 27
//6 : 20
//7 : 13
//12 : 18
//15 : 21
//20 : 25
// 종료시간보다 시작시간이 늦다면 pop 후 집어넣는다 2,14 -> 15,21
// 마지막에 큐에서 나오지 못한 강의의 수가 필요한 강의실 개수다.
public class 강의실 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int study[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");

            study[i][0] = Integer.parseInt(str[1]);
            study[i][1] = Integer.parseInt(str[2]);
        }
        Arrays.sort(study, (o1, o2) -> o1[0] - o2[0]);


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(study[0][1]); // 종료시간을 넣어놓는다.
        for (int i = 1; i < study.length; i++) {
            if (queue.peek() <= study[i][0]) {
                queue.poll();
            }
            queue.add(study[i][1]);
        }
        System.out.println(queue.size());
    }
}
