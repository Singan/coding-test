package sparta.week1;
//https://www.acmicpc.net/problem/2018

import java.io.IOException;
import java.util.Scanner;

public class 수들의합5 {
    //시작점과 끝점이 첫 번째 원소의 인덱스를 가리키게 한다.
    //현재 부분 합이 n이면 count 증가, start 증가
    //현재 부분 합이 n보다 크면 start 증가 (i)
    //현재 부분 합이 n보다 작으면 end 증가 (j)
    //2~4번 반복


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int num = 0;
        int result = 0;
        for(int i = 1 ; i <=n ; i++){
            for (int j = i ; j <=n ; j++){
                num += j;
                if(num > n){
                    break;
                }
                if(num== n){
                    result++;
                    break;
                }
            }
            num=0;
        }
        System.out.println(result);
    }
}
