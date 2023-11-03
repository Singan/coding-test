package backjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlpabetCpunt {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bf = new StringBuilder() ;
        int[] count = new int[26];
        String str = br.readLine();
        for (int i = 0;i<str.length();i++){
            count[str.charAt(i) -'a']++;
        }
        for (int i = 0;i<26;i++){
            bf.append(count[i]).append(" ");
        }
        System.out.println(bf);

    }
}
