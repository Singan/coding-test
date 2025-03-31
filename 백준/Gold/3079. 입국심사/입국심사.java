import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
        long min = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0; // 심사를 받을 수 있는 총 인원 수 (long으로 변경)

            for (int time : times) {
                count += mid / time;
                if (count >= s) break; // 불필요한 연산 방지 (시간 절약)
            }

            if (count < s) { // 심사 가능한 인원이 부족하면 시간 증가
                start = mid + 1;
            } else { // 조건을 만족하면 최소 시간을 갱신하고 더 작은 값 탐색
                min = mid;
                end = mid - 1;
            }
        }
        System.out.println(min);
    }
}
