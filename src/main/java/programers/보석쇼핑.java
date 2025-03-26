package programers;

import java.util.*;

public class 보석쇼핑 {

    public int[] solution(String[] gems) {


        Map<String, Integer> gemIndex = new HashMap<>();
        int index = 0;
        for (String gem : gems) {
            if (!gemIndex.containsKey(gem)) {
                gemIndex.put(gem, index++);
            }
        }

        int gemTypes = gemIndex.size(); // 보석의 총 개수
        int[] gemCount = new int[gemTypes]; // Map 대신 배열 사용
        int diff = Integer.MAX_VALUE;
        int[] answer = new int[2];

        int start = 0;
        int end = 0;
        int count = 0;
        while (end < gems.length) {
            int gemCountIndex = gemIndex.get(gems[end]);
            if (gemCount[gemCountIndex] == 0) {
                count++;
            }
            gemCount[gemCountIndex]++;
            end++;

            while (count == gemTypes) {
                if (diff > end - start) {
                    diff = end - start;
                    answer[0] = start + 1;
                    answer[1] = end ;
                }
                int startIdx = gemIndex.get(gems[start]);
                gemCount[startIdx]--;
                if (gemCount[startIdx] == 0) count--;
                start++;

            }


        }
        return answer;
    }
}
