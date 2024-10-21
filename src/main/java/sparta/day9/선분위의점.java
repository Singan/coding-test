package sparta.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선분위의점 {
    // 일차원 좌표상의 점 N개와 선분 M개가 주어진다.
    // 이때, 각각의 선분 위에 입력으로 주어진 점이 몇 개 있는지 구하는 프로그램을 작성하시오.
    // 첫째 줄에 점의 개수 N과 선분의 개수 M이 주어진다. (1 ≤ N, M ≤ 100,000) 둘째 줄에는 점의 좌표가 주어진다.
    // 두 점이 같은 좌표를 가지는 경우는 없다.
    // 셋째 줄부터 M개의 줄에는 선분의 시작점과 끝점이 주어진다.
    // 입력으로 주어지는 모든 좌표는 1,000,000,000보다 작거나 같은 자연수이다.
    //5 5
    //1 3 10 20 30
    //1 10
    //20 60
    //3 30
    //2 15
    //4 8
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] dot = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[0]);
//            int result = binarySearch(start, end);

//            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
