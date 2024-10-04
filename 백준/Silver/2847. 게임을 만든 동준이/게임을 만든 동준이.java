import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2847
// 마지막 값은 항상 최고값이여한다.
// 마지막 이전 값은 마지막 값보다 1 작아야 한다.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                int dif = arr[i] - (arr[i] - arr[i + 1] + 1);
                count += arr[i] - dif;
                arr[i] = dif;

            }
        }
        System.out.println(count);
    }
}
