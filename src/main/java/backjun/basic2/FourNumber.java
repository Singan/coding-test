package backjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FourNumber {
    //네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
    //
    //두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.
    //
    //입력
    //첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)
    //
    //출력
    //A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fourNumber [] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        long result = 0;
        for (int i = 0;i< fourNumber.length;i++){
            result += Long.parseLong(fourNumber[i]+fourNumber[++i]);

        }
        System.out.println(result);
    }
}
