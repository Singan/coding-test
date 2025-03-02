class Solution {
    public int[] solution(int n, int s) {
        if(s == 1 || s < n)
            return new int[]{-1};

        int avg = s / n;
        int remainder = s % n;
        int[] answer = new int[n];
        int i = n-1;
        while (remainder > 0) {
            remainder -= 1;
            answer[i] += 1;
            i--;
        }
        for (int j = n-1; j >=0; j--) {
            answer[j] += avg;
        }
        return answer;
    }
}