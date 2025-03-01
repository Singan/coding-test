
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            answer++;
            right--;
        }
        return answer;
    }
}