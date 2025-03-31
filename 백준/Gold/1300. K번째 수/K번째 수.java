import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  // n을 long으로 변경
        long k = sc.nextLong();  // k를 long으로 변경

        long start = 1;
        long end = n * n;

        long result = 1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 1; i <=n; i++) {
                count += Math.min(mid / i , n);
            }
            if(count < k){
                start = mid + 1;
            }else{
                end = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);

    }
}
