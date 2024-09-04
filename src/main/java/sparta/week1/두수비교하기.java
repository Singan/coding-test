package sparta.week1;

import java.io.*;
import java.util.StringTokenizer;

//문제
//두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
//
//출력
//첫째 줄에 다음 세 가지 중 하나를 출력한다.
//
//A가 B보다 큰 경우에는 '>'를 출력한다.
//A가 B보다 작은 경우에는 '<'를 출력한다.
//A와 B가 같은 경우에는 '=='를 출력한다.
public class 두수비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        // 삼항 연산자로 표현 불가능
        if(a > b) {
            System.out.println(">");
        } else if(a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}
