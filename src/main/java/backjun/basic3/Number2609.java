package backjun.basic3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Number2609 {
    //두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    //
    //출력
    //첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        long minGop = 0;
        int maxNamuge = maxNamuge(a,b);
        System.out.println(maxNamuge);
        System.out.println(minGop(a,b,maxNamuge));


    }
    public static int maxNamuge(int a , int b ){
        int min = a<b?a:b;
        int max = a>b?a:b;
        int namuge = max%min;
        if(namuge!=0){
            return maxNamuge(min,namuge);
        }
        return min;
    }
    public static int minGop(int a , int b ,int maxNamuge){
        return (a*b)/maxNamuge;
    }
}
