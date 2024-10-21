package sparta.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2847
// 마지막 값은 항상 최고값이여한다.
// 마지막 이전 값은 마지막 값보다 1 작아야 한다.
// 이전 값이 크다면 이전 값 -현재 값 +1 만큼의 차이를 이전 값에서 뺀다. 그럼 이전 값보다 1 작다.
// 그리고 뺀 값을 count에 더한다.
public class 게임을만든동준이 {
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
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        int count = 0;
//        for (int i = n - 2; i >= 0; i--) {
//            if(arr[i] >= arr[i+1]){
//                arr[i]--;
//                i++;
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
}
