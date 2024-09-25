package sparta.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean chk = true;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            boolean curChk = true;

            if(cur=='<') {
                stackPop(stack,sb);
                chk = false;
                curChk = false;
            }
            if(cur=='>'){
                chk = true;
                curChk = false;
            }
            if(cur==' ' && chk){
                stackPop(stack,sb);
                curChk = false;
            }


            if(!chk || !curChk){
                sb.append(cur);
            }else {
                stack.push(cur);
            }
        }

        stackPop(stack,sb);


        System.out.println(sb.toString());



    }
    public static void stackPop(Stack stack , StringBuilder sb){
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

}
