package sparta.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2167
// S[i][j] = A[i][j] + S[i-1][j] + S[i][j-1] - S[i-1][j-1]
//내 예제
//3 3
//1 2 3
//4 5 6
//7 8 9
//1
//2 3 3 3
// 누적합
// 1 3 6
//5 12 21
//12 27 45
public class 이차원배열의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]) + 1;
        int z = Integer.parseInt(str[1]) + 1;
        StringTokenizer st;
        int[][] arr = new int[n][z];
        int[][] prefixSum = new int[n][z];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < z; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                prefixSum[i][j] = arr[i][j]
                        + prefixSum[i - 1][j]  // 위쪽 값 더하기
                        + prefixSum[i][j - 1]  // 왼쪽 값 더하기
                        - prefixSum[i - 1][j - 1];  // 중복된 대각선 값을 빼기

            }
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        // 누적합에서 값 꺼내기
        // 부분합도 결국 사각형 모양인데
        // 사각형의 윗 , 맨 아래 왼쪽을 뺴고 위 바로 왼쪽(대각선)을 더하면 값이 나온다.
        for (int v = 0; v < k; v++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = prefixSum[x][y]
                    - prefixSum[i - 1][y]
                    - prefixSum[x][j - 1]
                    + prefixSum[i - 1][j - 1];

            // 결과 출력
            System.out.println(sum);
        }


    }
}
