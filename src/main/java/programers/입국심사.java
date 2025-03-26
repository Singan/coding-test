package programers;

import java.util.Arrays;
import java.util.*;

public class 입국심사 {


    public static void main(String[] args) {
        System.out.println(solution(6 , new int[]{7,10}));;
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = times[times.length - 1] * (long) n;
        long result = 0;
        while (start <= end) {
            long mid = (end + start) / 2;
            int count = 0;
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
