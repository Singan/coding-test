package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수 {
    //어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다. 제곱수는 정수의 제곱이다
    // . min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());


        int dp[] = new int[(int) (max - min + 1) + 1];
        long j;

        int index = 1;
        for (long i = min; i <= max; i++) {
            dp[index] = dp[index - 1];
            for (j = 2; j <= max; j++) {
                if (j * j > max) {
                    break;
                }
                if (i % (j * j) == 0) {
                    break;
                }
            }
            if (i % (j * j) != 0) {
                dp[index] += 1;
            }
            index++;
        }
        System.out.println(dp[dp.length - 1]);
    }
}
