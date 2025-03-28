import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int search[] = new int[m];
        for (int i = 0; i < m; i++) {
            search[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            int start = 0, end = n - 1;
            int answer = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                int searchValue = search[i];

                int value = arr[mid];
                if (searchValue == value) {
                    answer = 1;
                    break;
                }

                if (value < searchValue) {
                    start = mid + 1;  // start 값을 mid + 1로 갱신
                } else {
                    end = mid - 1;  // end 값을 mid - 1로 갱신
                }

            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
