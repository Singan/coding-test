
import java.util.Scanner;

//https://www.acmicpc.net/problem/3192
public class Main {

    //
    // daldidalgo 까지 8 daldida까지해서 9 n 까지 10
    // n 이 1일때 10
    // n 2 : daldidalgo daldidalgo daldidan : 11초
    // n 3 : daldidalgo daldidalgo 9초 daldidalgo daldida 10초 n 11초
    // n 4 : daldidalgo daldidalgo 9초 daldidalgo daldidalgo 10초 daldidan 12초
    // n 5 : daldidalgo daldidalgo 9초 daldidalgo daldidalgo 10초 daldidalgo daldida 11초 n 12초
    // n 6 : daldidalgo daldidalgo 9  daldidalgo daldidalgo 10 daldidalgo  daldidalgo daldida 11 초 n 12
    // n 7 : daldidalgo daldidalgo 9초 daldidalgo daldidalgo 10초 daldidalgo daldidalgo daldidalgo  daldida 11초 n 12초
    // n 8 : daldidalgo daldidalgo 9초 daldidalgo daldidalgo 10초 daldidalgo daldidalgo daldidalgo 11초 daldidalgo daldida 12초 n 13초
    // n 9 : daldidalgo daldidalgo 9초 daldidalgo daldidalgo 10초 daldidalgo daldidalgo daldidalgo daldidalgo 11초 daldidalgo daldida 12초 n 13초

    //2->4 4->8 에 시간이 1초 오르고 있다. 즉 2의 제곱과 관련이 있다.

    // 1은 2의 0^임으로 10초
    // 2는 n 의 1^임으로 11초
    // 4는 n 의 2^임으로 12초
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n>1){
            n = n/2;
            count++;
        }

        System.out.println(count+9+n);

    }

}
