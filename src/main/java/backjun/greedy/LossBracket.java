package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LossBracket {
    //세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
    //
    //그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
    //
    //괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
    //입력
    //첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
    // 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
    // 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] minusNumber = str.split("-");
        int result = 0;
        for (int i = 0; i < minusNumber.length; i++) {
            String numbers[] = minusNumber[i].split("\\+");
            if (minusNumber.length > 1 && i > 0) {
                for (String s : numbers) {
                    result -= Integer.parseInt(s);
                }
            } else {
                for (String s : numbers) {
                    result += Integer.parseInt(s);
                }
            }
        }
        System.out.println(result);
    }
}
