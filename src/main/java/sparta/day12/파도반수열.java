package sparta.day12;

import java.util.Scanner;

// 점화식 f(n) = f(n-2) + f(n-3)
public class 파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            long arr[] = new long[Math.max(n, 4)];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 2;
            if (n < 3) {
                System.out.println(arr[n-1]);
                continue;
            }
            for (int j = 4; j < n; j++) {
                arr[j] = arr[j - 2] + arr[j - 3];
            }
            System.out.println(arr[n - 1]);
        }

    }
}
