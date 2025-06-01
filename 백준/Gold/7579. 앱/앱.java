import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memorys = new int[n];
        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memorys[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            totalCost += costs[i];
        }

        // dp[i] = i비용으로 확보할 수 있는 최대 메모리
        int[] dp = new int[totalCost + 1];

        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            int memory = memorys[i];
            for (int j = totalCost; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + memory);
            }
        }

        // 최소 비용을 찾아 출력
        int result = 0;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= m) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
