package programers;

import java.util.Arrays;

public class 인사고과 {
    public static void main(String[] args) {
        int r = new Solution().solution(new int[][]{{1,4}, {3,2}, {3,2} ,{2,2},{3,1}});
        System.out.println(r);
    }

    static class Solution {
        public int solution(int[][] scores) {
            int answer = 1;
            int[] wanho = scores[0];
            int wanhoSum = wanho[0] + wanho[1];

            Arrays.sort(scores,(o1, o2) -> o2[0] == o1[0]?o1[1] - o2[1]:o2[0] - o1[0]);
            int max=0;

            for (int i = 0; i < scores.length; i++) {
                int[] people = scores[i];
                int peopleSum = people[0] + people[1];
                if(max>people[1]){
                    continue;
                }else{
                    max=people[1];
                }
                if (wanhoSum < peopleSum) {
                    answer++;
                }
                if (people[0] > wanho[0] && people[1] > wanho[1]) {
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }
}
