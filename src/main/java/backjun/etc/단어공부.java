package backjun.etc;

import java.util.Scanner;

public class 단어공부 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        char ch = ' ';
        int maxCount = 0;

        int stack = 0;
        for (char i = 'A';str.length()>0; i++) {
            int prevLength = str.length();
            str = str.replace(i+"","");

            int diff = prevLength-str.length();
            if(diff>maxCount){
                maxCount=diff;
                ch = i;
                stack=0;
            }else if(maxCount>0 && maxCount==diff){
                stack++;
            }
        }
        System.out.println(stack==0?ch:"?");
    }
}
