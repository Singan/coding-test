import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zero = str.indexOf('0');
        int n = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            n += str.charAt(i) - '0';
        }
        Arrays.sort(chars);
        if (zero != -1 && n % 3 == 0) {
            for (int i = chars.length-1; i >=0; i--) {
                System.out.print(chars[i]);
            }
        } else {
            System.out.println(-1);
        }
    }
}
