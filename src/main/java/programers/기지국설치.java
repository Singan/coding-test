package programers;

public class 기지국설치 {
    public static void main(String[] args) {
        int a =new Solution().solution(13, new int[]{3, 7, 11}, 1);
        System.out.println(a);
    }

    private static class Solution {
        public int solution(int n, int[] stations, int w) {
            int location = 1;
            int i = 0;
            int count = 0;
            while (true) {
                if (i > stations.length - 1 ) {
                    break;
                }
                int stationMinusRange = stations[i] - w;
                int stationPlusRange = stations[i] + w;
                if (location < stationMinusRange) {
                    count+=operating(stationMinusRange,location,w);
                }
                location = stationPlusRange + 1;
                i++;
            }
            if (location < n) {
                count+=operating(n,location,w);
                System.out.println(location);

            }

            return count;
        }

        public int operating(int n, int location, int w) {
            int count = 0;
            int range = (2 * w) + 1;

            int dif = n - location;
            int mod = dif % range;
            int nanum = dif / range;
            count += nanum;
            if (mod > 0) {
                count++;
            }
            return count;
        }
    }
}
