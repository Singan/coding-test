import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2847
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
                int dif = arr[i] - (arr[i + 1] - 1); // 현재 값을 이전 값보다 1 작게 설정
                count += dif; // 차이만큼 count 증가
                arr[i] = arr[i + 1] - 1; // arr[i]를 arr[i+1]보다 1 작게 설정
            }
        }
        System.out.println(count);
    }
}
