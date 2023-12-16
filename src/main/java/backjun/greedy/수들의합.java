package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 수들의합 {
    //서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        int count = 0;
        long temInt = s;
        for (long i = 1; i <=s; i++) {
            if(temInt-i >=i ){
                temInt-=i;
                count++;
            }else if(temInt-i == 0){
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}
