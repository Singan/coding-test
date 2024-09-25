package sparta.day4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 알파벳블록 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> deque = new ArrayDeque<>();
        //스택의 경우 vector 를 상속받아 성능적으로 좋지 않아 권장되지 않는다.
        Deque<Integer> commands = new ArrayDeque<>(); // 맨 마지막에 추가한 문자열을 지우려면 어떤 명령을 수행했는지 알아야한다.
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            int command = chars[0] - 48;
            switch (command){
                case 1:
                    deque.addLast(chars[2]);
                    commands.push(command);
                    break;
                case 2:
                    deque.addFirst(chars[2]);
                    commands.push(command);
                    break;
                case 3:
                    if(commands.isEmpty())
                        break;
                    if(commands.pop()==1){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }

                    break;
            }
        }
        while(!deque.isEmpty()) {
            char ch = deque.pop();
            sb.append(ch);
        }
        bw.write(sb.toString().isEmpty() ? "0" : sb.toString());
        bw.flush();
    }
}
