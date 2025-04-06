import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
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
