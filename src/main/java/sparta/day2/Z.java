package sparta.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1074
public class Z {
    //첫째 줄에 정수 N, r, c가 주어진다.
    //2^N * 2^N : 배열의 크기
    // r, c 찾고싶은 배열의 위치
    //배열을 사분면으로 나누고 또 해당 사분면을 사분면으로 나눈다.
    //2^N / 2  를 통해 사분면의 중심을 알아내고 r,c를 통해 어떤 사분면인지 알 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);

        int r = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        int result = deep((int) Math.pow(2, N), r, c);
        System.out.println(result);
    }

    public static int deep(int N, int r, int c) {
        int centerPoint = N / 2;

        if (centerPoint <= 1)
            return (r*2) + c; // 마지막 행은 무조건 2,3이기 때문에 *2 + 0,1로 2,3으로 가릴수있다.

        int max = N * N;


        // 각 사분면의 시작하는 수를 구하기 위해 4로 나눈다.
        int start = max / 4;
        if (r < centerPoint) {//1,3사분면 조건 행 번호가 중앙점보다 작으면.
            if (c < centerPoint) {//1사분면 조건 열 번호가 중앙 점보다 작으면.
                start = start * 0;
            } else {// 나머지 3분면
                start = start * 1;
                c = c - centerPoint;
            }
        } else {
            if (c < centerPoint) {//2사분면 조건
                r = r - centerPoint;
                start = start * 2;
            } else {// 나머지 4분면
                r = r - centerPoint;
                c = c - centerPoint;
                start = start * 3;
            }
        }





        return start + deep(centerPoint, r, c);


    }
}
