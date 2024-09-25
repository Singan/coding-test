package sparta.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10828
public class 스택 {
    static Stack<Integer> stack = new Stack<>();

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    System.out.println(stack.size() == 0 ? -1:stack.get(stack.size() - 1));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    if(stack.size() == 0 ){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                    break;
                case "empty":
                    System.out.println(stack.isEmpty()?1:0);
                    break;
            }
        }
        br.close();
    }
}
