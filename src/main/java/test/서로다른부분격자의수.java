package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분격자의수 {

    // a ~ z 까지의 알파벳이 적힌 격자들이 있다.
    // 이 중 4칸을 묶어 부분 격자라 한다. 부분 격자의 수는 (N-1)^2
    // 부분 격자의 위치는 다르더라도 알파벳이 동일하다면 동일한 격자로 취급한다.
    // 서로 다른 부분 격자의 수를 구해라
    //3
    //BBA
    //BBB
    //ABB
    // 부분 격자의 수 3
    // 문자를 객체에 변수별로 넣어서 hashCode를 이용한다.
    // 이후 해시 맵을 이용하면 객체의 중복으로 중복된 격자를 제외할 수 있다.
    // String 으로 해결

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        char arr[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        Set<String> hashSet = new HashSet<String>();

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = 0; j <= arr[i].length - 2; j++) {
                String str = "" + arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                hashSet.add(str);
            }
        }
        System.out.println(hashSet.size());
    }
}
