package backjun.basic1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExam {
    //정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
    //
    //명령은 총 여섯 가지이다.
    //
    //push X: 정수 X를 큐에 넣는 연산이다.
    //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //size: 큐에 들어있는 정수의 개수를 출력한다.
    //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList();
        for (int i= 0; i<count;i++){
            String[] s = br.readLine().split(" ");
            switch (s[0]){
                case "push":
                    queue.add(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    Integer pop = queue.poll();
                    bf.write((pop==null?"-1":pop)+"\n");
                    break;
                case "size":
                    bf.write((queue.size())+"\n");
                    break;
                case "empty":
                    bf.write((queue.isEmpty()?1:0)+"\n");
                    break;
                case "front":
                    bf.write((queue.peek()==null?-1: queue.peek())+"\n");
                    break;
                case "back":
                    bf.write((queue.peekLast()==null?-1: queue.getLast())+"\n");
                    break;
            }
        }
        bf.flush();
    }
}
