
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 1. 총 이동 횟수 출력
        System.out.println((int) Math.pow(2, n) - 1);

        // 2. 이동 순서 출력
        hanoi(n, 1, 3, 2);
        System.out.println(sb);
    }

    static StringBuffer sb = new StringBuffer();

    public static void hanoi(int n, int start, int end, int sub) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(n - 1, start, sub, end);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(n - 1, sub, end, start);
    }
}
