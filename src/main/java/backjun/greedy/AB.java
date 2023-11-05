package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AB {
    //16953번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int i = 1;
        // 맨 뒷자리가 2로 나눠지지 않거나 1이 아니면 답은 -1이다. (문제가 2를 곱하는 것이기 때문)
        while (true) {
            int n = b / 10;
            if (b == a) {//B가 A 까지 왔다면 끝
                break;
            }
            if((b%10 > 1 && b%2!=0 )||b<a){ // 맨뒷자리가 1을 넘으며 2로 나눠지지않거나 B가 A보다 작아진 경우
                i=-1;
                break;
            }
            if (n != 0 && b % 10 == 1) {
                b = n;

            } else {
                b /= 2;
            }
            i++;
        }
        System.out.println(i);

    }
}
