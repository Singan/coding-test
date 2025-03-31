import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list , Comparator.comparingInt(o -> o[0]));
        int dp[] = new int[n + 1];
        Arrays.fill(dp,1);
        int lis = 0;
        for (int i = 1; i <n; i++) {
            for (int j = 0; j <i; j++) {
                if(list.get(i)[1] > list.get(j)[1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(dp[i] , lis);
        }
        System.out.println(n - lis);
    }

}
