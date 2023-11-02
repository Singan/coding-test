package backjun.basic2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Oakensu {
    //문제
    //크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
    // Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
    //
    //예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
    // A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
    //
    //입력
    //첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
    //
    //출력
    //총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        String[] stringSplit = br.readLine().split(" ");
        int[] numberArr = new int[count];

        for (int i = 0; i < count; i++) {
            numberArr[i] = Integer.parseInt(stringSplit[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[count];
        for (int i = 0;i<count;i++){
            while (!stack.isEmpty() && numberArr[stack.peek()]<numberArr[i]){
                result[stack.pop()] = numberArr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        for (int i = 0; i < count; i++) {
            bw.write(result[i]+ (count-1==i?"":" "));
        }

        bw.flush();
    }
}

//3 5 2 7
//
//0을 담는다
//
//3과 5 비교
//5를 결과값에 담음
//1을 담는다
//2를 담는다.
//2와 7 을 비교
//7을 결과 값에 담는다
//
//다시 한번 픽을한다
//5와 7을 비교한다
//7을 담는다
//3을 담는다
// 스택에는 3만이 담겨있는데 이 자리에 -1을 채우도록 한다.
//5 7 7