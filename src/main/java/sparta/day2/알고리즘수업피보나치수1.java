package sparta.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알고리즘수업피보나치수1 {
    //오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다.
    // 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자.
    // 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
    //피보나치 수 재귀호출 의사 코드는 다음과 같다.
    //fib(n) {
    //    if (n = 1 or n = 2)
    //    then return 1;  # 코드1
    //    else return (fib(n - 1) + fib(n - 2));
    //}
    //피보나치 수 동적 프로그래밍 의사 코드는 다음과 같다.
    //
    //fibonacci(n) {
    //    f[1] <- f[2] <- 1;
    //    for i <- 3 to n
    //        f[i] <- f[i - 1] + f[i - 2];  # 코드2
    //    return f[n];
    //}
    static int[] f; //동적 프로그래밍에서 사용하는 의사코드
    static int count1, count2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine()); //입력 값(n)
        f = new int[n]; //동적 프로그래밍에서 사용하는 배열 초기화

        br.close();

        /* 카운트 변수 초기화 */
        count1 = 0;
        count2 = 0;
        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    public static int fib(int n){
        if(n == 1 || n==2){
            count1++;
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }
    public static int fibonacci(int n){ // for 문이 i= 3 부터 시작하여 n 보다 작기때문에 n-2 로 봐도 무방하다.
        //즉 for 문의 반복 횟수는 n-2이다.
        f[0] = 1;
        f[1] = 1;

        for(int i = 2; i < n; i++){
            count2++;
            f[i] = f[i-1] + f[i-2];


        }
        return f[n-1]; //배열은 0부터 시작하므로
        //return n-2;

    }
}
