package sparta.day1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 별찍기 {
    //입력
    //5
    //예제 출력 1
    //*        *
    //**      **
    //***    ***
    //****  ****
    //**********
    //****  ****
    //***    ***
    //**      **
    //*        *

    //현재 줄 번호 == 별의 개수
    // 5- 현재 줄 번호 == 공백 개수
    //5- 현재 줄 번호의 == 공백 개수
    //현재 줄 번호 == 별의 개수
    //--------------------
    //다음 줄을 다시 초기화
    //5- 현재 줄 번호 == 별의 개수
    //현재 줄 번호 == 공백 개수
    //현재 줄 번호 == 공백 개수
    //5- 현재 줄 번호 == 별의 개수

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            bf.append("*".repeat(i));
            bf.append(" ".repeat((n - i) * 2));
            bf.append("*".repeat(i));
            bf.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            bf.append("*".repeat(n - i));
            bf.append(" ".repeat(i * 2));
            bf.append("*".repeat(n - i));
            bf.append("\n");
        }

        bf.flush();
    }
}
