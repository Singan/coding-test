import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 보유한 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        int[] lans = new int[k];

        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans); // 정렬 (필수는 아님)

        long left = 1; // 최소 랜선 길이 (0이면 안 됨)
        long right = lans[k - 1]; // 가장 긴 랜선
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2; // (right + left) / 2 보다 안전한 계산법

            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lans[i] / mid; // mid 길이로 몇 개를 만들 수 있는지 계산
            }

            if (count >= n) { // 🔥 원하는 개수 이상 만들 수 있음
                result = mid; // mid 값 저장 (최대한 길게)
                left = mid + 1; // 더 긴 길이를 시도
            } else {
                right = mid - 1; // 개수가 부족하면 더 짧게
            }
        }

        System.out.println(result); // 최적의 랜선 길이 출력
    }
}
