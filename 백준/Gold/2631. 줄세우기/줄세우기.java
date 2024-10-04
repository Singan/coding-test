import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2631
// n - 가장 긴 증가하는 수열을 구하면 된다고 한다.
// 가장 긴 증가하는 수열을 구하는 방법은
// 3 7 5 2 6 1 4
// 3 5 6
// 0번에 1을 넣고 1번의 수가 이전 수보다 이전 값 +1 한 값을 갖는다.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cpyArr[] = new int[n];

        cpyArr[0] = 1;

        for (int i = 1; i < n; i++) {
            cpyArr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    cpyArr[i] = Math.max(cpyArr[j] + 1, cpyArr[i]); // 최장 수열이기에 MAX
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < cpyArr.length; i++) {
            maxLength = Math.max(maxLength , cpyArr[i]);
        }

        System.out.println(n - maxLength);
    }
}
