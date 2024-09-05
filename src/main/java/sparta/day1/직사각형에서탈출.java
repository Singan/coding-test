package sparta.day1;

import java.io.*;
import java.util.StringTokenizer;
//한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 x, y, w, h가 주어진다.
//
//출력
//첫째 줄에 문제의 정답을 출력한다.

//현재 위치 x,y 에서 둘 중 하나만 w,h 중 하나로 가면 된다.
// 또는 w ,h 보다 0,0 중 하나라도 가장 가깝다면 그쪽으로 가면 된다.
public class 직사각형에서탈출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int x = Integer.parseInt(st.nextToken());
        final int y = Integer.parseInt(st.nextToken());
        final int w = Integer.parseInt(st.nextToken());
        final int h = Integer.parseInt(st.nextToken());

        int a = w-x < x ? w-x : x;
        int b = h-y < y ? h-y : y;
        int result = a < b ? a : b;

        bf.write(Integer.toString(result));
        bf.flush();

    }
}
