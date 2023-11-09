package programers;

public class 택배배달과수거하기 {
    //너무 어려워서 나중에

    private static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = -1;
            int c = cap;
            for (int i = n-1; i >=0; i--) {
                if(deliveries[i]>=c){
                    deliveries[i]-=c;
                }

            }

            return answer;
        }
    }
}
