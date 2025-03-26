package programers;

import java.util.PriorityQueue;
import java.util.Stack;

public class 큰수만들기 {
    public String solution(String number, int k) {


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() &&
                    stack.peek() < number.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(number.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
