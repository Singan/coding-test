package programers;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(String s) {
            HashMap<String,Integer> numberCount = new HashMap<>();
            int pushCount = 0;
            s = s.replaceAll("\\{", "");
            String[] sArr = s.substring(0, s.length() - 2).split("\\}\\,");
            for (int i = 0; i < sArr.length; i++) {
                String[] numberArr = sArr[i].split(",");
                for (int j = 0; j < numberArr.length; j++) {
                    Integer count = numberCount.get(numberArr[i]);
                    count = count==null?0:count;
                    numberCount.put(numberArr[i],count+1);
                }
            }
            final int n = numberCount.size();
            int[] answer = new int[n];
            for (int i = 0; i < answer.length; i++) {
            }

            return answer;
        }
    }
}
