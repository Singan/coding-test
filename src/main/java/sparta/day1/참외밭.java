package sparta.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5번 문제
public class 참외밭 {
    //첫 번째 줄에 1m2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K (1 ≤ K ≤ 20)가 주어진다.
    // 참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여
    // 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이 (1 이상 500 이하의 정수)
    // 가 둘째 줄부터 일곱 번째 줄까지 한 줄에 하나씩 순서대로 주어진다.
    // 변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
    // **반드시 시계 반대 방향**
    // 동 서 중 최대값 * 북 남 중 최대값 == 직사각형의 넓이
    // 직사각형 넓이 - 작은 직사각형 넓이
    // 가장 큰 변이 하나 나오면 그 변의 앞 뒤 인덱스는 세로 또는 가로의 빈 사각형의 차이를 알 수 있다.
    // 작은 변에서는 다음 변의 방향이 어디로 갈 지 알 수 없다.
    public static void main(String[] args) throws IOException {
        // 6면이 나온다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sideCount = 6;
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[sideCount];

        int maxHeight = 0;
        int maxHeightIndex = 0;
        int maxWidth = 0;
        int maxWidthIndex = 0;
        for (int i = 0; i < sideCount; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[i] = length;
            if (direction == 1 || direction == 2) {
                if (maxWidth < length) {
                    maxWidthIndex = i;
                    maxWidth = length;
                }
            } else {
                if (maxHeight < length) {
                    maxHeightIndex = i;
                    maxHeight = length;
                }
            }
        }
        int x = Math.abs(arr[maxWidthIndex + 1 < sideCount ? maxWidthIndex+1 : 0 ]
                - arr[maxWidthIndex - 1 >= 0 ? maxWidthIndex - 1 : sideCount - 1]);
        int y = Math.abs(arr[maxHeightIndex + 1 < sideCount ? maxHeightIndex+1 : 0 ]
                - arr[maxHeightIndex - 1 >= 0 ? maxHeightIndex - 1 : sideCount - 1]);
        int result = maxWidth * maxHeight - x * y;
        System.out.println(result * n);

    }
}
