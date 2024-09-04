package backjun.basic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11441
public class 합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[n];
        int sum = 0;
        String[] str= br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {

            sum += Integer.parseInt(str[i]);
            prefixSum[i] += sum;
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int result = prefixSum[y];
            if(z > 0){
                result -= prefixSum[z-1];
            }
            System.out.println(result);
        }
    }
}
