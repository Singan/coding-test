package sparta.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기2재풀이 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();
        int i = 0;
        while(i<chars.length){
            if(chars[i]=='<'){
                while(chars[i++]!='>'){} // i 라는 포인터를 <가 나오면 >까지 넘어가기 위해 ++연산자로 while문을 돌린다.
            }else {
                int start = i; // 시작점을 저장한 후 끝 점을 찾는 while 을 돌린다.
                while(i<chars.length && chars[i] != '<'&&chars[i] != ' '){
                    i++;
                }
                int end = i-1; // 배열이라 0부터 시작하기 때문에 -1을 해준다.
                reverse(chars, start, end);
                if(i<chars.length && chars[i]!='<') {
                    i++;
                }
                // 바로 위 while 문을 나왔단 것은 공백이 나온 것
                // 이를 지나가기 위에 +1을 해준다. <의 경우 위 if문에서 처리함으로 넘어가도 된다.
            }
        }
        System.out.println(chars);

    }

    public static void reverse(char[] chars , int start, int end){
        while(start<end){ // start 가 end 보다 같거나 커지면 다 뒤집은 것
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            // start 와 end 를 바꿔준다. 이 둘을 좁혀나간다.
            start++;
            end--;

        }
    }
}
