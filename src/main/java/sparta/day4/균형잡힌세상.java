package sparta.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            Deque<Character> deque = new ArrayDeque<>();
            if(str.charAt(0) == '.')
                break;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[') {
                    deque.addLast(ch);
                } else if (ch == ')') {
                    // 가장 마지막에 추가한 괄호랑 짝이 안맞으면 균형이 맞지 않기 때문에 no 를 출력해야한다.
                    if (deque.isEmpty() || deque.peekLast() != '(') {
                        deque.addLast(ch);
                        break;
                    } else {
                        deque.removeLast();
                    }
                } else if (ch == ']' ) {
                    if (deque.isEmpty() || deque.peekLast() != '[') {
                        deque.addLast(ch);
                        break;
                    } else {
                        deque.removeLast();
                    }
                }

            }
            sb.append((deque.isEmpty() ? "yes" : "no"));
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}
