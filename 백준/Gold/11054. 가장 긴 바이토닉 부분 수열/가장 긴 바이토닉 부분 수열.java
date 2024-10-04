import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서 오른쪽으로 진행하는 증가하는 부분 수열의 길이
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 증가하는 수열 구하기 (left[])
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        // 감소하는 수열 구하기 (right[]) - 역방향 진행
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        // 가장 긴 바이토닉 수열의 길이 계산
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, left[i] + right[i] - 1);
        }

        System.out.println(maxLength);
    }
}
