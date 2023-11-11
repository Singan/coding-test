package programers;

public class 숫자타자대회 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int solution(String numbers) {
            String numberPad [][] = new String[][]{
                    {"1","2","3"},
                    {"4","5","6"},
                    {"7","8","9"},
                    {"*","0","#"}
            };
            String left = "4";
            String right = "6";
            int answer = 0;
            for (int i = 0; i < numbers.length(); i++) {
                if(left.equals(numbers.charAt(i))||right.equals(numbers.charAt(i))){
                    answer++;
                    continue;
                }
                
            }


            return answer;
        }
    }
}
