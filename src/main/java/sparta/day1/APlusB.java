package sparta.day1;

import java.io.*;
import java.util.StringTokenizer;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
public class APlusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        bf.write(Integer.toString(a + b));
        bf.flush();
    }
}
