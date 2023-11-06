package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬 {
    //1213 번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int alphabet[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        String mid = "";
        for (int i = 0; i < alphabet.length; i++) {

            for (int j = 0; j < alphabet[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
            if (alphabet[i] % 2 != 0)
                mid += (char) (i + 'A');
        }
        if (mid.length() > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            System.out.println(sb + mid + new StringBuilder(sb).reverse());

        }
    }
}
