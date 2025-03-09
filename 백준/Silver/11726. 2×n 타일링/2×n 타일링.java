import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        //int[] dp = new int[n + 1];


        int prev1 = 1;
        int prev2 = 2;

        if(n == 1||n == 2){
            System.out.println(n);
            return;
        }
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = (prev1 + prev2) % 10007;
            prev1 = prev2;
            prev2 = next;
        }

        System.out.println(next);
    }
}

