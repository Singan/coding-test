package programers;

import java.util.Arrays;

public class 인사고과 {
    public static void main(String[] args) {
        int r = new Solution().solution(new int[][]{{7, 1}, {6, 5}, {5, 4}, {5, 4}, {6, 2}});
        System.out.println(r);
    }

    static class Solution {
        public int solution(int[][] scores) {
            int answer = 1;
            int[] wanho = scores[0];
            int wanhoSum = wanho[0] + wanho[1];
            int [][] copyScores = new int[scores.length-1][2];
            for (int i = 1; i <= copyScores.length; i++) {
                copyScores[i-1] = scores[i];
            }
            Arrays.sort(copyScores,(o1, o2) -> o2[0] == o1[0]?o2[1] - o1[1]:o2[0] - o1[0]);
            int max0 = copyScores[0][0];
            int max1 = copyScores[0][1];
            for (int i = 0; i < copyScores.length; i++) {
                int[] people = copyScores[i];
                int peopleSum = people[0] + people[1];
                if(max0>people[0]){
                    if(max1>people[1])
                        continue;
                }
                if (wanhoSum < peopleSum) {
                    answer++;
                }
            }
            if (max0 > wanho[0] && max1 > wanho[1]) {
                answer = -1;
            }
            return answer;
        }
    }
}
