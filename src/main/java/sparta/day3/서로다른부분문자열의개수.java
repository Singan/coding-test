package sparta.day3;

import java.io.*;
import java.util.HashSet;


public class 서로다른부분문자열의개수 {
    //문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
    //
    //부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
    //
    //예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc,
    // abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();// set 으로 중복 문자열 저장으로 길이 구하기
        for (int i = 0 ; i<str.length();i++){//각 문자의 시작점
            for (int j = i + 1; j <= str.length(); j++) {//시작점에서 몇글자까지 자를지
                String subStr = str.substring(i,j); // 변수에 담아서 했을 때와 안했을 때 성능 차이가 조금 났다. (안담는 쪽이 더 좋음)
                set.add(subStr);
            }
        }
        System.out.println(set.size());

    }
}
