package programers;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[]s = new Solution().solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19});
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {1,2,3,4,5,6,6};
            int max = 0;
            int min = 0;
            Arrays.sort(lottos);
            Arrays.sort(win_nums);
            int startNo = 0;
            for (int i = 0; i <lottos.length ; i++) {
                int curNumber = lottos[i];
                if(curNumber==0){
                    max++;
                    continue;
                }
                for ( int j =startNo ;j < win_nums.length; j++) {
                    if(curNumber==win_nums[j]){
                        startNo++;
                        max++;
                        min++;
                        break;
                    }
                }

            }


            return new int[]{answer[6-max],answer[6-min]};
        }
    }
}
