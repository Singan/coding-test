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
        int start = 0;
        int end = n - 1;
        int answer[] = new int[2];
        answer[1] = end;
        answer[0] = start;
        int minAbs = Math.abs(arr[start] + arr[end]);
        while (start < end) {

            int sum = arr[start] + arr[end];
            int newAbs = Math.abs(sum);
            if(minAbs > newAbs){
                minAbs  = newAbs;
                answer[0] = start;
                answer[1] = end;
            }
            if(sum < 0){
                start++;
            }else{
                end--;
            }

        }
        System.out.println(arr[answer[0]] + " " + arr[answer[1]]);
    }
}
