package basic1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackExam {
    //정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
    //명령은 총 다섯 가지이다.
    //push X: 정수 X를 스택에 넣는 연산이다.
    //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //size: 스택에 들어있는 정수의 개수를 출력한다.
    //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static List<Integer> stack = new ArrayList<>();
    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i=0;i<count;i++){
            switch (scanner.next()){
                case "push":
                    stack.add(Integer.parseInt(scanner.next()));
                    break;
                case "top":
                    if(stack.size()==0){
                        System.out.println(-1);
                        break;
                    }                    System.out.println(stack.get(stack.size()-1));;
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    if(stack.size()==0){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                    break;
                case "empty":
                    if(stack.size()==0){
                        System.out.println(1);
                        break;
                    }else{
                        System.out.println(0);
                        break;
                    }
            }
        }


    }
}
