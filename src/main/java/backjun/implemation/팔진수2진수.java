package backjun.implemation;

import java.util.Scanner;

public class 팔진수2진수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 48;
            int chk = 2 * 2;
            for (int j = 0; j < 3; j++) {
                if (n / chk > 0) {
                    answer.append(1);
                    n %= chk;
                }else if(answer.length()>=1 || (i==str.length()-1 &&j==2)){
                    answer.append(0);
                }
                chk /= 2;
            }
        }
        System.out.println(answer.toString());
    }
}
