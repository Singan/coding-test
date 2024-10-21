package sparta.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 규칙
// %30 != 0 일때
// 수에 0이 있다면 자리를 마지막 자리와 바꿔본다. 없다면 -1
// 있다면 바꾸고 나눴을때 %30 != 0 이면 다른 자리와 바꿔도 안되는 것 같다.
// 이 규칙은 자리수를 더했을 때 3의 배수면 성립한다. 즉 모든자리를 더해 3으로 나눠본다.
// 가장 큰 수 이기에 배열로 받아 정렬한다. 만약 수 중 0이 있다면 모든 자리수의 합이 %3 == 0 인지확인한다.
// 위의 조건이 안된다면 -1 된다면 배열을 역순으로 출력한다.
//https://www.acmicpc.net/problem/10610
// ** 가장 큰 수
public class 삼십 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zero = str.indexOf('0');
        int n = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            n += str.charAt(i) - '0';
        }
        Arrays.sort(chars);
        if (zero != -1 && n % 3 == 0) {
            for (int i = chars.length-1; i >=0; i--) {
                System.out.print(chars[i]);
            }
        } else {
            System.out.println(-1);
        }
    }
}
