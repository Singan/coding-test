package backjun.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            queue.add(arr[i]);
        }
        if (n == 1) {
            System.out.println(queue.poll());
            return;
        }

        int answer = 0;

        while (queue.size()>1) {
            int sum = queue.poll() + queue.poll();
            queue.add(sum);
            answer+=sum;
        }

        System.out.println(answer);
    }
}
