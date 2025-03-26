package programers;

import java.util.Arrays;

public class 정수삼각형 {
    public static void main(String[] args) {

    }

    public int solution(int[][] triangle) {

        for (int i = triangle.length - 1; i > 0; i--) {
            int[] curLine = triangle[i];
            for (int j = 0; j < triangle[i].length - 1; j++) {
                int curNode = curLine[j] > curLine[j + 1] ? curLine[j] : curLine[j + 1];
                triangle[i - 1][j] += curNode;
            }
        }
        int answer = triangle[0][0];
        return answer;
    }
}
