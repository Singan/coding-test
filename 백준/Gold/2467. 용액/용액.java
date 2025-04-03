import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        int left = 0;
        int right = n - 1;
        int minAbs = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int newAbs = Math.abs(sum);
            if (newAbs < minAbs) {
                minAbs = newAbs;
                answer1 = arr[left];
answer2 = arr[right];            }
            if(sum==0) break;
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
