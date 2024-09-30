package sparta.day7;

import java.io.*;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/13116

// 입력 : 테스트케이스 개수
// a, b
// 로직 : a 와 b 를 2로 계속 나누어 서로 공통되는 가장 큰 값을 찾으면 될 것같다.
// 2로 나누면 부모 노드에 접근되기 때문에 더 큰 쪽을 계속 2로 나누어 부모 노드를 비교하면 될 것 같다.
public class 삼십번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while(a!=b){
                if(a>b) {
                    a = a / 2;
                }else{
                    b = b/2;
                }
            }
            sb.append(a*10).append("\n");
        }
        System.out.println(sb);
    }
}
