package sparta.day2;
//https://www.acmicpc.net/problem/2705

// 참고
// n의 재귀적인 팰린드롬 파티션에서 정가운데에 오는 숫자가
// i 일때 양 옆으로 올수 있는 재귀적인 팰린드롬은 (n-i/2)의 재귀적인 팰린드롬 파티션 개수와 일치한다.
//
// n의 재귀적인 팰린드롬 파티션의 개수는 i가
// 0부터 n까지 (n-i/2)의 재귀적인 팰린드롬 파티션개수의 합이다

import java.util.Scanner;

//주어진 정수 N에 대해 가능한 모든 파티션을 구하고,
//그중에서 재귀적인 팰린드롬 파티션을 찾아서 개수를 세는 것입니다.
public class 팰린드롬파티션 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[1001];
        partition(arr);
        for (int i = 0 ; i <t;i++){

            int n = sc.nextInt();
            System.out.println(arr[n]);

        }


    }

    static void partition(int[] arr){
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i - 1] + arr[i / 2];
            } else {
                arr[i] = arr[i - 1];
            }
        }
    }
}
