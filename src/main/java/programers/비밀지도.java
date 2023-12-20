package programers;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str[] = solution.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        for (String s : str) {
            System.out.println(s.toString());
        }
    }

    private static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            StringBuilder stringBuilder;
            for (int i = 0; i < n; i++) {
                int value1 = arr1[i];
                int value2 = arr2[i];
                int result = value1 | value2;
                stringBuilder = new StringBuilder();
                String binaryString = Integer.toBinaryString(result);
                System.out.println(binaryString);
                for(int j = n-binaryString.length();j>0;j--){
                    stringBuilder.append(" ");
                }
                for (int j = 0; j <binaryString.length(); j++) {
                    if (binaryString.charAt(j)=='1') {
                        stringBuilder.append("#");
                    } else {
                        stringBuilder.append(" ");
                    }
                }
                answer[i] = stringBuilder.toString();
            }


            return answer;
        }
    }

    public void convertBinary() {

    }
}
