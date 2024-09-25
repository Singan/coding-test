package sparta.day5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.acmicpc.net/problem/1966
public class 프린터큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer testCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCase; i++) {
            String[] str = br.readLine().split(" "); // 페이지 개수와 타겟
            int n = Integer.parseInt(str[0]);
            int target = Integer.parseInt(str[1]);
            LinkedList<int[]> queue = new LinkedList<>();
            String[] page = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(page[j]);
                queue.add(new int[]{j, value});
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll(); // 현재 페이지보다 큰 값이 있는지 확인해야한다.
                boolean isMax = true; //해당 요소가 가장 큰지 확인해야함.
                for (int j = 0; j < queue.size(); j++) {
                    int[] next = queue.get(j);
                    if (cur[1] < next[1]) {
                        queue.add(cur); // queue 요소중 더 큰 요소가 있다면 마지막으로
                        for (int z = 0; z < j; z++) {
                            //queue의 j번째에 cur(뽑은 요소)보다 큰 게 있는 것이므로
                            // j까지만 반복한다.
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break; // 한번 정렬을했다면 그대로 반복문을 종료한다.
                    }
                }
                if (isMax) {
                    count++;
                    if (cur[0] == target) { // 만약 현재 인덱스가 타겟이면서 최대 값이라면 출력하는 것이기때문에 break 한다.
                        bf.write(count + "\n");
                        break;
                    }
                }
            }
        }
        bf.flush();
    }
}
