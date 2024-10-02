import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int lenA = a.length();
        int lenB = b.length();
        int[][] arr = new int[lenA + 1][lenB + 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1; // 현재 위치 이전의 값을 가져온다.
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        System.out.println(arr[lenA][lenB]);
    }
}
