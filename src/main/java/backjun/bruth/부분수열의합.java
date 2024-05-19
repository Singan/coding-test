package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 부분수열의합 {
    //문제
    //N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
    // 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
    static int[] arr;
    static boolean[] visit;
    static int n;
    static int s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }


        dfs(0, 0);
        if (s == 0) System.out.println(count - 1);
        else  System.out.println(count);


    }

    public static void dfs(int i, int sum) {


        if (i == n) {
            if (sum == s) {
                count++;
                return;
            }
            return;
        }
        dfs(i+1, sum + arr[i]);
        dfs(i+1, sum);

    }
}
