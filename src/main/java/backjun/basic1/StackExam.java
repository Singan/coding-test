package backjun.basic1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StackExam {
    //정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
    //명령은 총 다섯 가지이다.
    //push X: 정수 X를 스택에 넣는 연산이다.
    //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //size: 스택에 들어있는 정수의 개수를 출력한다.
    //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
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
    //풀이 후기
    // 처음에 리스트로 했으나(스택이란 자료구조 자체를 구현하는 문제로 생각) 고침
    // 계속 시간초과가 뜨길래 스캐너에 nextLine 특성 상 마지막 입력에 개행문자가 없으면 엔터를 한번 더 쳐줘야 해서 그런줄 암.
    // 알고보니 그냥 버퍼더리더를 쓰면 됨
}
