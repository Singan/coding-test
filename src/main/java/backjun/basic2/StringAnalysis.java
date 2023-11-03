package backjun.basic2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAnalysis {
    //문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
    //
    //각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
    //
    //입력
    //첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.
    //
    //출력
    //첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int[] result = new int[4];
            for (int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if ('A' <= currChar && currChar <= 'Z') {
                    result[1]++;
                } else if ('a' <= currChar && currChar <= 'z') {
                    result[0]++;
                } else if ('0' <= currChar && currChar <= '9') {
                    result[2]++;
                } else {
                    result[3]++;
                }
            }
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
