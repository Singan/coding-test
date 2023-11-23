package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 카드합체놀이 {
    public static void main(String[] args) throws Exception{
        Queue<Long> queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        Long answer = 0L;
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        String numberList[] = br.readLine().split(" ");
        for (int i = 0; i < numberList.length; i++) {
            queue.offer(Long.parseLong(numberList[i]));
        }
        for (int i = 0; i < m; i++) {
            Long number1 = queue.poll();
            Long number2 = queue.poll();
            number1+=number2;
            number2 = number1;
            queue.offer(number1);
            queue.offer(number2);
        }
        while (!queue.isEmpty()){
            Long number1 = queue.poll();
            answer+=number1;
        }
        System.out.println(answer);
    }
}
