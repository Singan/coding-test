package programers;

public class 미로탈출명령어 {
    //    l: 왼쪽으로 한 칸 이동 2
//    r: 오른쪽으로 한 칸 이동 3
//    u: 위쪽으로 한 칸 이동 4
//    d: 아래쪽으로 한 칸 이동 1
    public static void main(String[] args) {
        String s = Solution.solution(3, 4, 2, 3, 3, 1, 5);
        System.out.println(s);
    }

    //    문자열이 사전 순이어야 한다는 조건과 이동 거리가 정해져 있다는 점에서 탐색을 쓰지 않는 방법도 있습니다.
//    우선 사전 순서 조건을 고려하면 최적의 해는 d 반복 -> l 반복 -> rl 반복 -> r 반복 -> u 반복의 형태를 가집니다. 반복수를 구하는 방법은
//    d -> ‘l 또는 r’ -> u 순으로 최단 거리로 이동한 경로에 남은 거리(k – 최단 경로 길이)가 존재한다면 d, l, rl, r, u를 채워 넣는 방법입니다.
//    남은 거리는 (d, u), (l, r)이 대칭이 된다는 점과 격자의 크기를 이용해 (d, u), (l, r)을 최대한 채우고,
//    그래도 남는다면 rl 반복으로 채우면 최적의 해가 나옵니다.
    private class Solution {
        public static String solution(int n, int m, int x, int y, int r, int c, int k) {
            StringBuilder sb = new StringBuilder();
            int left = y - c > 0 ? y - c : 0; // 시작 X 축 빼기 도착 X축 0보다 작으면 도착점이 더 적으니 왼쪽으로
            int up = x - r > 0 ? x - r : 0; // 시작 Y 축 빼기 도착 Y축
            int down = r - x > 0 ? r - x : 0;
            int right = c - y > 0 ? c - y : 0;
            int total = Math.abs(r - x) + Math.abs(c - y);
            int totalDiff = total - k;
            int pair = Math.abs(totalDiff / 2);
            if (total > k || totalDiff % 2 != 0) { // 움직일 수 있는 거리가 모자른 경우
                return "impossible";
            }
            for (int i = 0; i < k; i++) {
                if ((down > 0 || pair > 0) && x < n) { // 시작 Y 축이 더 낮다.
                    if (down > 0) {
                        down--;
                    } else {
                        pair--;
                        up++;
                    }
                    x++;
                    sb.append("d");
                } else if ((left > 0 || pair > 0) && y > 1) {
                    if (left > 0) {
                        left--;
                    } else {
                        pair--;
                        right++;
                    }
                    y--;
                    sb.append("l");
                } else if ((right > 0 || pair > 0) && y < m) {
                    if (right > 0) {
                        right--;
                    } else {
                        pair--;
                        left++;
                    }
                    y++;
                    sb.append("r");
                } else {
                    up--;
                    sb.append("u");
                    x--;
                }
            }

            return sb.toString();
        }

    }
}
