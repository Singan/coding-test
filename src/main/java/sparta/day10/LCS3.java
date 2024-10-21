package sparta.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//a,b,c 의 문자
// a의 첫 문자열에서 b,c contains 를 한다.
// true 라면 배열에 담는다.
// 배열의 값과 두 번째 문자열과 더하여 contains를
// false 라면 start ++
//--------- XX------------
// 각 문자열의 int 배열을 선언한다.
// a 의 문자열의 첫 번째 문자열을 b 문자열에서의 위치를 찾는다. 없다면 넘어간다.
// b 에서 찾았다면 b 에서 찾은 문자열의 위치를 int 배열에 넣고 c를 찾으면 될 것 같다.
public class LCS3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        int[][][] arr = new int[lenA + 1][lenB + 1][lenC + 1];

        for (int i = 1; i < arr.length; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j < arr[i].length; j++) {
                char bChar = b.charAt(j - 1);

                for (int k = 1; k < arr[i][j].length; k++) {
                    if (bChar == c.charAt(k - 1) && (aChar == bChar)) {
                        arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
                    } else {
                        arr[i][j][k] = Math.max(arr[i - 1][j][k], Math.max(arr[i][j - 1][k], arr[i][j][k - 1]));

                    }

                }
            }
        }

        System.out.println(arr[lenA][lenB][lenC]);
    }
}
