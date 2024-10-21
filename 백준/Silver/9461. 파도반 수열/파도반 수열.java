import java.io.*;

/*
 * 점화식 : p(n) = p(n-2) + p(n-3)
 * dp배열 long으로 해주어야 함.
 */
class Main {
	static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		initializeDP();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb);
	}

	static void initializeDP() {
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}
	}
}