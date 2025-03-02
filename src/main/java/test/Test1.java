package test;

import java.nio.charset.StandardCharsets;

public class Test1 {
    static class Solution {
        private static final String str = "이노룰스Innorules";

        public void solution(int byteSize) {
            if (byteSize < 2) {
                System.out.println("출력 불가능");
                return;
            }

            int countByte = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : str.toCharArray()) {
                int charByteSize = (c <= 127) ? 1 : 2; // 영어는 1바이트, 한글은 2바이트

                if (countByte + charByteSize > byteSize) {
                    System.out.println(sb);
                    sb.setLength(0); // StringBuilder 초기화
                    countByte = 0;
                }

                sb.append(c);
                countByte += charByteSize;
            }

            // 마지막 남은 문자열 출력
            if (sb.length() > 0) {
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3); // 예제 실행
    }
}
