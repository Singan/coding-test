import java.io.BufferedReader;
import java.io.InputStreamReader;

//특정 수를 기준으로 왼쪽에 위치한 숫자는 증가하고
// 오른쪽에 위치한 숫자는 감소하는 형태를 띤 부분 수열을 의미한다.
//https://www.acmicpc.net/problem/11054
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = 1;
            int cur = Integer.parseInt(str[i]);
            for (int j = i - 1; j >= 0; j--) {
                int prev = Integer.parseInt(str[j]);
                if (prev < cur) { // 이전 값보다 크다면 해당 수열에 들어갈 수 있다. ( 증가하는 수열 )
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) { // 헷갈리니 역순으로 진행
            right[i] = 1;
            int cur = Integer.parseInt(str[i]);
            for (int j = i; j < n; j++) {
                int next = Integer.parseInt(str[j]);
                if (cur > next) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        // dp 배열 중에서 가장 큰 값 찾기


        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, left[i] + right[i] - 1);
        }
        System.out.println(maxLength);

    }
}
