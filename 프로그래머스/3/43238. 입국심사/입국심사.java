import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = times[times.length - 1] * (long) n;;
        long result = 0;
        while (start <= end) {
            long mid = (end + start) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if (count < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}