package sparta.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1946


// 입력 : 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
// 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적,
// 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
// 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.

// 풀이 : 두 성적중 하나의 성적을 기준으로 정렬한다. 그 후
// 나머지 하나의 성적을 기준으로 다음 사람과 해당 성적을 비교한다. 만약 다음 사람의 성적이 더 높다면 result 를 1올린다.
// 만약 다음 사람의 성적이 더 높다면 기준점(min)을 갱신한다.
// 맨 첫번째 사람은 무조건 합격이기에 result 는 1로 시작한다.

//2차원 배열을 1차원 배열로 바꿀 수 있다. 방의 개수는 정해져있고 중복석차는 없기때문에
// 앞에 성적을 기준으로 배열에 넣으면 정렬을 한 효과가 나온다.
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int result = 1;

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken() )-1] = Integer.parseInt(st.nextToken());
            }
            int min = arr[0];


            for (int i = 1; i < arr.length; i++) {
                if(min > arr[i]){
                    result++;
                    min = Math.min(min , arr[i]);
                }
            }
            System.out.println(result);


        }
    }
}
