import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + 1 < arr[i]) {  // sum + 1이 다음 추가 되기 전까지 만들 수 있는 최대 무게
                break;  // 측정할 수 없는 최소값을 찾았으므로 탈출
            }
            sum += arr[i];  // 가능한 무게 범위 확장
        }
        System.out.println(sum + 1);  // 측정할 수 없는 최소값 출력
    }
}
