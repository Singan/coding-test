
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  // n을 long으로 변경
        long k = sc.nextLong();  // k를 long으로 변경

        long start = 1;  // 최소값은 1
        long end = n * n;  // 최대값은 n * n
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            // mid 이하인 값들의 개수 세기
            for (long i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);  // j의 최대값은 n
            }

            if (count < k) {
                start = mid + 1;  // k보다 작으면 start를 올려야 함
            } else {
                end = mid - 1;  // k보다 크거나 같으면 end를 낮춰야 함
                result = mid;  // 적당한 mid를 result에 저장
            }
        }

        System.out.println(result);
    }
}
