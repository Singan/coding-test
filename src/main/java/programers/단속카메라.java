package programers;

import java.util.Arrays;

public class 단속카메라 {
    public static void main(String[] args) {

    }
    private static class Solution {
        public int solution(int[][] routes) {

            int answer = 0;
            int max =-30001;
            Arrays.sort(routes,(o1, o2)->o1[1]-o2[1]);
            for(int i = 0 ; i<routes.length;i++){
                if(routes[i][0]>max){
                    max = routes[i][1];
                    answer++;
                }
            }



            return answer;
        }
    }
}
