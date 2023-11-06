package programers;

import java.util.Arrays;

public class 레벨테스트1 {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3}}));
    }
    private static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int i = 0 ; i <commands.length;i++){
                int[] com = commands[i];
                int [] arr = new int[com[1]-com[0]+1];
                for (int j = com[0]-1; j <com[1]; j++) {

                    arr[j-com[0]+1] = array[j];

                }
                Arrays.sort(arr);
                answer[i] = arr[com[2]-1];
            }
            return answer;
        }
    }

}
