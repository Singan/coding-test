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
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // A 전봇대 기준으로 정렬
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));

        // LIS를 구하기 위한 DP 배열 초기화
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // 최소 부분 수열 길이는 1 (자기 자신)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j)[1] < list.get(i)[1]) {  // 증가하는 부분 수열 조건
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // LIS의 최대 길이 계산
        int lisLength = Arrays.stream(dp).max().orElse(1);

        // 최소 제거 전깃줄 수: 전체 전깃줄 - LIS 길이
        System.out.println(n - lisLength);
    }
}
