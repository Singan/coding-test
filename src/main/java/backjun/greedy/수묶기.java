package backjun.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v > 1) {
                plus.add(v);  // 양수 (1 제외)
            } else if (v == 1) {
                sum += 1;  // 1은 더하는 것이 이득
            } else {
                minus.add(v);  // 음수 및 0
            }
        }


        while (!plus.isEmpty()) {
            int num1 = plus.poll();
            if (plus.isEmpty()) {
                sum += num1;
                break;
            }
            int num2 = plus.poll();
            sum += num2 * num1;
        }
        while (!minus.isEmpty()) {
            int num1 = minus.poll();
            if (minus.isEmpty()) {
                sum += num1;
                break;
            }
            int num2 = minus.poll();
            sum += num2 * num1;
        }
        System.out.println(sum);
    }
}
