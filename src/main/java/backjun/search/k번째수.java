package backjun.search;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class k번째수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long start = 0;
        long end = n * n;

        long result = 0;

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
