package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        int result = 0;


        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                if (i == right) {
                    right--;
                    continue;
                }
                if (i == left) {
                    left++;
                    continue;
                }
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    result++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(result);
    }
}
