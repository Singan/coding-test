package sparta.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//https://www.acmicpc.net/problem/1026
// 입력 : N 과 두 줄
// 각 줄은 N 개의 숫자.
// 문제 : 두 수열의 숫자를 각각 곱하고 다 더했을 때 가장 낮은 값이 나와야 한다.
// 큰 숫자와 작은 숫자를 곱할수록 총 합은 작아진다.
// 정렬을 통해 배열을 작은 순서와 큰 순서로 정렬해서 서로 곱한다.
// 하지만 내림차순은 Primitive 타입은 불가능하다.
// count - i 를 통해 역순으로 스캔
public class 보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0 ;
        for (int i = 0; i < count; i++) {
            result+=a[i] * b[count - i - 1];
        }
        System.out.println(result);
    }
}
