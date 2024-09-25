package sparta.day4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

//https://www.acmicpc.net/problem/3986
public class 좋은단어 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int result = 0;
        //현재 문자 값이 스택의 top과 같으면 pop
        //
        //현재 문자 값이 스택의 top과 다르면 push
        //
        //모두 비교 후 스택이 empty이면 좋은 단어이다.
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            Deque<Character> deque = new ArrayDeque<>();
            for (int j = 0; j < chars.length; j++) {
                if(deque.isEmpty()) {
                    deque.push(chars[j]);
                    continue;
                }
                if(deque.peek() == chars[j]){
                    deque.pop();
                }else{
                    deque.push(chars[j]);
                }
            }

            result = deque.isEmpty() ? result+1 : result;

        }
        System.out.println(result);

    }
}
