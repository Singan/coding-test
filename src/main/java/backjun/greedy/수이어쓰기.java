package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수이어쓰기 {
    //세준이는 1부터 N까지 모든 수를 차례대로 공백없이 한 줄에 다 썼다. 그리고 나서, 세준이가 저녁을 먹으러 나간 사이에 다솜이는 세준이가 쓴 수에서
    // 마음에 드는 몇 개의 숫자를 지웠다.
    //
    //세준이는 저녁을 먹으러 갔다 와서, 자기가 쓴 수의 일부가 지워져있는 모습을 보고 충격받았다.
    //
    //세준이는 수를 방금 전과 똑같이 쓰려고 한다. 하지만, N이 기억이 나지 않는다.
    //
    //남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램을 작성하시오. 아무것도 지우지 않을 수도 있다.)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int numberIndex = 0;

        int min = 0;
        while (true) {
            String minString = String.valueOf(min); // 101
            for (int i = 0; i < minString.length(); i++) {
                if (minString.charAt(i) == str.charAt(numberIndex)) {
                    numberIndex++;
                }
                if (numberIndex == str.length()) {
                    System.out.println(min);
                    return;
                }
            }
            min++;
        }
    }
}
