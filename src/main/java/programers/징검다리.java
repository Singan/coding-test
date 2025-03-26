package programers;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;
        while (left < right) {
            int start = 0;
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - start < mid) {
                    count++;
                } else {
                    start = rocks[i];  // 바위 사이의 거리가 mid 이상이면 start 갱신
                }
            }
            if (distance - start < mid) count++;

            if (count <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return answer;
    }
}
