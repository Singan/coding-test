package programers;

public class 레벨테스트2 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(13,17));;
    }
    private static class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <=right; i++) {
                int r = 0;
                for (int j = 1; j <= i; j++) {
                    if(i%j==0){
                        r++;
                    }
                }
                if(r%2==0){
                    answer+=i;
                }else{
                    answer-=i;
                }
            }


            return answer;
        }
    }
}
