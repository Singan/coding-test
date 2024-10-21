package sparta.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문서검색 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String subStr = br.readLine();

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }

        System.out.println(count);
    }
}