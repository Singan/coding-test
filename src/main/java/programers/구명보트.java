package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 구명보트 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 50, 80}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        for (int i = 0; i < people.length; i++) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            answer++;
            right--;
            if(left >= right)
                break;
        }
        return answer;
    }
}
