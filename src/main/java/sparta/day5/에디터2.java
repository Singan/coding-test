package sparta.day5;
//https://www.acmicpc.net/problem/1406

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;

public class 에디터2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        String initialText = br.readLine(); // 시작 텍스트
        int count = Integer.parseInt(br.readLine()); // 명령 횟수
        // 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
        // 오른쪽에서 왼쪽은 후입선출이다.
        // 빠진 문자열은 LIFO 로 출력 시 순서가 다시 보장되기에 stack 을 사용하면 된다.
        // 즉 기본 스택과 커서를 움직여 빠질 스택 두개를 준비하면 된다.
        ArrayDeque<Character> cursor = new ArrayDeque<>();
        ArrayDeque<Character> trash =  new ArrayDeque<>();
        
        for (int i = 0 ; i<initialText.length() ; i++){
            cursor.add(initialText.charAt(i)); // 문자열 큐에 세팅
        }
        
        
        for (int i = 0; i < count; i++) {
            String order = br.readLine();
            switch (order.charAt(0)) {
                case 'P':
                    cursor.add(order.charAt(2));
                    break;
                case 'L':
                    if (!cursor.isEmpty())
                        trash.add(cursor.pollLast());
                    break;
                case 'B':
                    if (!cursor.isEmpty()){
                        cursor.pollLast();
                    }
                    break;
                case 'D':
                    if (!trash.isEmpty())
                        cursor.add(trash.pollLast());
                    break;
            }
        }
        while (!cursor.isEmpty()){
            bf.write(cursor.pop()); // cursor 에 있는 문자는 선입선출로 나갈 수 있다.
        }
        while (!trash.isEmpty()){
            bf.write(trash.pollLast()); // trash 에 있는 문자는 후입선출로 나가면 기존의 순서가 보장된다.
        }
        bf.flush();
    }
}
