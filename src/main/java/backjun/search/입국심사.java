package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());


        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(times);

        long start = 1;
        long end = (long) times[n - 1] * s; // 최악의 경우 (가장 느린 심사관이 모든 사람을 처리)
        long min = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
                if (count >= s) break;
            }

            if (count < s) {
                start = mid + 1;
            } else {
                min = mid;
                end = mid - 1;
            }
        }
        System.out.println(min);
    }
}