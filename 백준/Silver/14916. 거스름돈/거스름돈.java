
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int fiveWon = n / 5;
        int twoWon = (n % 5) / 2;
        int count = fiveWon + twoWon;

        int val = twoWon * 2 + fiveWon * 5;
        while (fiveWon > 0 && val != n) {
            fiveWon--;
            twoWon = (n - (fiveWon * 5)) / 2;
            count = fiveWon + twoWon;
            val = twoWon * 2 + fiveWon * 5;
        }
        System.out.println(val == n ? count : -1);


    }
}
