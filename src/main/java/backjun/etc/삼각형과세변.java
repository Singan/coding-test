package backjun.etc;

import java.util.Arrays;
import java.util.Scanner;

public class 삼각형과세변 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = {
                "Scalene", "Isosceles ", "Equilateral", "Invalid"
        };
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        while (scanner.hasNextLine()) {
            int max = Arrays.stream(new int[]{a, b, c}).max().getAsInt();
            int sum = a + b + c - max;
            int chk = 0;
            if (a + b + c == 0)
                break;

            if (a == b) {
                chk++;
                if (b == c) {
                    chk++;
                }
            }else if (b == c || a==c) {
                chk++;
            }
            if (sum <= max) {
                chk = 3;
            }
            System.out.println(strings[chk]);
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        }
    }
}
