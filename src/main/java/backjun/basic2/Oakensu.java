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
            // 3 5 2 7
            // 스택 숫자 1, i = 2
            while (!stack.isEmpty() && numberArr[stack.peek()]<numberArr[i]){
                System.out.println(i);
                result[stack.pop()] = numberArr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        for (int i = 0; i < count; i++) {
            bw.write(result[i]+"");
            if (i < count - 1) {
                bw.write(" ");
            }
        }
        bw.flush();
    }
}
