package backjun.basic3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Remain {
    //(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
    //세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
    //
    //출력
    //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int a =  Integer.parseInt(str[0]);
        int b =  Integer.parseInt(str[1]);
        int c =  Integer.parseInt(str[2]);

        sb.append((a+b)%c +"\n");
        sb.append(((a%c) + (b%c))%c +"\n");
        sb.append((a*b)%c +"\n");
        sb.append(((a%c) * (b%c))%c);
        System.out.println(sb);

    }
}
