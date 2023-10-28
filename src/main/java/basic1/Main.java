package basic1;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String s[] = scanner.nextLine().split(" ");
            System.out.println(i+" : " +s[0]);
            switch (s[0]) {
                case "push":
                    stack.push(Integer.parseInt(s[1]));
                    break;
                case "top":
                    //System.out.println(stack.size() == 0 ? -1:stack.get(stack.size() - 1));
                    break;
                case "size":
                   // System.out.println(stack.size());
                    break;
                case "pop":
                    if(stack.size() == 0 ){
                     //   System.out.println(-1);
                        break;
                    }
                    //System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                    break;
                case "empty":
                   // System.out.println(stack.isEmpty()?1:0);
                    break;
            }
        }


    }


}
