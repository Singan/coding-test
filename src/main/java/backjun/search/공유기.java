package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lans = new int[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lans);
        int left = 0;
        int right = lans[k - 1] - lans[0];  // 최대 거리
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int before = lans[0];
            for (int i = 1; i < k; i++) {
                if (lans[i] - before >= mid) {
                    count++;
                    before = lans[i];
                }
            }

            if (count >= n) {
                left = mid + 1;
                result = mid;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
