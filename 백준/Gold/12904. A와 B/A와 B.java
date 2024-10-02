//https://www.acmicpc.net/problem/12904
// 문자앞에 A가 있고 뒤에 A가 없으면 못한다.
// 문자를 추가하는 연산은 딱 두 종류이다.
// 두 연산은 맨 마지막 문자에만 추가된다.
// 즉 마지막 문자를 보면 마지막 연산을 알 수 있다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
// A = 맨 뒤에 추가
// B = 뒤집고 맨 뒤에 추가
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(br.readLine());

        while (sb.length() > 0) {

            char ch = sb.charAt(sb.length() - 1);
            if (ch == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (ch == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }


            if (sb.toString().equals(s))
                break;
        }
        System.out.println(sb.length() > 0 ? 1 : 0);
    }
}
