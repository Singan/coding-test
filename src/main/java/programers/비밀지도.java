package programers;

import java.util.*;
import java.util.stream.IntStream;

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
            return IntStream.range(0, n)
                    .mapToObj(i -> Integer.toBinaryString(arr1[i] | arr2[i]))
                    .map(s -> {
                        StringBuilder stringBuilder = new StringBuilder();
                        for(int j = n-s.length();j>0;j--){
                            stringBuilder.append(" ");
                        }
                        for (int j = 0; j <s.length(); j++) {
                            if (s.charAt(j)=='1') {
                                stringBuilder.append("#");
                            } else {
                                stringBuilder.append(" ");
                            }
                        }
                        return stringBuilder.toString();
                    })
                    .map(s -> s.replaceAll("1", "#").replaceAll("0", " "))
                    .toArray(String[]::new);
        }

    }
}
