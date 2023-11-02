package backjun.basic1;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class WordReverse2 {
    //문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
    //
    //먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
    //
    //알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
    //문자열의 시작과 끝은 공백이 아니다.
    //'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
    //태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
    // 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
    //첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
    //
    //출력
    //첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean chk = true;
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (curr == '<') {
                if(i>0){
                    System.out.println(reverse(chars,i,index));
                }
                chk = false;
            } else if (curr == '>') {
                chk = true;
                stringBuilder.append(curr);
                index = i;
            }
            if(!chk){
                stringBuilder.append(curr);
            }
        }
        bw.write(stringBuilder.toString());
        bw.flush();
    }
    public static String reverse(char[] chars,int i,int last){
        String ss = "";
        for(int j = i-1;j>last;j--){
            ss += chars[j];
        }
        return ss;
    }
}



//import java.io.*;
//        import java.util.Iterator;
//        import java.util.Stack;
//
//public class Main {
//    //문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
//    //
//    //먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
//    //
//    //알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
//    //문자열의 시작과 끝은 공백이 아니다.
//    //'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
//    //태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
//    // 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
//    //첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.
//    //
//    //출력
//    //첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str =  br.readLine();
//        Stack<Character> stack = new Stack<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        boolean chk = true;
//        for (int i= 0 ; i<str.length();i++){
//            char curr = str.charAt(i);
//            if(curr=='<'){
//                while (!stack.isEmpty()){
//                    stringBuilder.append(stack.pop());
//                }
//                chk=false;
//                stringBuilder.append(curr);
//                continue;
//            }else if(curr=='>'){
//                chk=true;
//                stringBuilder.append(curr);
//                continue;
//            }else if(' '==curr){
//                while (!stack.isEmpty()){
//                    stringBuilder.append(stack.pop());
//                }
//                stringBuilder.append(curr);
//            }
//            else if(!chk) {
//                stringBuilder.append(curr);
//            } else if(chk)
//                stack.push(curr);
//
//        }
//        while (!stack.isEmpty()){
//            stringBuilder.append(stack.pop());
//        }
//        bw.write(stringBuilder.toString());
//        bw.flush();
//
//    }
//}
