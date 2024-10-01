import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/1863
//고도가 바뀌면 다른 사각형이다
// 높이가 높아지면 건물이 뒤에 더있다.
// 높이가 낮아지면 건물이 끝이다.
// 반복: ---------------------------
// 이전 값보다 낮은 값이 들어오면 스택에서 나간다.
// 카운트를 1 올린다.
// 다시 확인한다.
//--------------------------
// 이전 값보다 높은 값이 들어오면 스택에 넣는다.
// 마지막에 size (남은 건물의 수) 만큼 더한다.
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {

            String str[] = br.readLine().split(" ");
            int height = Integer.parseInt(str[1]);

            while (!stack.isEmpty() && stack.peek() > height) { // height 가 더 작으면 건물이 끝났다는 뜻
                stack.pop();
                count++;
            }
            // 만약 1 2 3 2가 들어오면 스택은 1 2 2가 되기에 같은 값이면 처리를 해줘야함.
            if(!stack.isEmpty() && stack.peek() == height || height == 0){
                continue;
            }
            stack.push(height);
        }


        System.out.println(count + stack.size());

    }
}
