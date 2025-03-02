package programers;

public class 최고의집합 {
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
        for (int j = 0; j < n; j++) {
            answer[j] += avg;
        }
        return answer;
    }
}
