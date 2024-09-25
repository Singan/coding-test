package sparta.day5;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

//https://www.acmicpc.net/problem/1406
public class 에디터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> text = new LinkedList<>();
        ListIterator<Character> cursor = text.listIterator();

        String initialText = br.readLine();
        int count = Integer.parseInt(br.readLine());
        for (char c : initialText.toCharArray()) {
            cursor.add(c);
        }
        for (int i = 0; i < count; i++) {
            String order = br.readLine();
            switch (order.charAt(0)) {
                case 'P':
                    cursor.add(order.charAt(2));
                    break;
                case 'L':
                    if (cursor.hasPrevious())
                        cursor.previous();
                    break;
                case 'B':
                    if (cursor.hasPrevious()){
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'D':
                    if (cursor.hasNext())
                        cursor.next();
                    break;
            }
        }

        text.stream().forEach(character -> {
            try {
                bf.write(character);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bf.flush();
        bf.close();
    }
}
