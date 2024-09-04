package sparta.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2167
//S[i][j] = A[i][j] + S[i-1][j] + S[i][j-1] - S[i-1][j-1]
public class 이차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int z = Integer.parseInt(str[1]);
        StringTokenizer st;
        int[][] arr = new int[n][z];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < z; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        // 각 배열을 돌며 i,j 에서 x,y 까지의 값을 모두 더한다.
        for (int v = 0; v < k; v++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int a = i-1 ; a < x ; a++){
                for(int s = j-1 ; s<y; s++){
                    sum+= arr[a][s];
                }
            }
            System.out.println(sum);
        }


    }
}
