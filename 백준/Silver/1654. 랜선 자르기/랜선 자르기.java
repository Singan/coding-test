import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lans = new long[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lans);

        long left = 1;
        long right = lans[lans.length - 1];
        long result = 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += lans[i] / mid;
            }
            if (count >= n) {
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}
