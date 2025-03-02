package test;
//N 이 주어질 때 1<=a <= b=<n 이며 b 분에 a 가 몇개

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 기약분수 : 분모 분자 공약수가 1뿐
public class 기약분수 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int a = i;
            int b = n - a;
            if (b < a)
                break;



            while (true) {
                int temp = a;
                a = b % a;
                b = temp;

                if(a == 0)
                    break;
            }

            if(b == 1)
                result++;
        }
        System.out.println(result);
    }
}
