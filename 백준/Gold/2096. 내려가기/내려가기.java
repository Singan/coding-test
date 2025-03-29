import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][3];
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 행 dpMax, dpMin 초기화
        dpMax[0] = arr[0][0];
        dpMax[1] = arr[0][1];
        dpMax[2] = arr[0][2];
        dpMin[0] = arr[0][0];
        dpMin[1] = arr[0][1];
        dpMin[2] = arr[0][2];

        // DP 테이블 갱신
        for (int i = 1; i < n; i++) {
            int[] current = arr[i];

            int prevMax0 = dpMax[0], prevMax1 = dpMax[1], prevMax2 = dpMax[2];
            int prevMin0 = dpMin[0], prevMin1 = dpMin[1], prevMin2 = dpMin[2];

            dpMax[0] = Math.max(prevMax0, prevMax1) + current[0];
            dpMax[1] = Math.max(prevMax0, Math.max(prevMax1, prevMax2)) + current[1];
            dpMax[2] = Math.max(prevMax2, prevMax1) + current[2];

            dpMin[0] = Math.min(prevMin0, prevMin1) + current[0];
            dpMin[1] = Math.min(prevMin0, Math.min(prevMin1, prevMin2)) + current[1];
            dpMin[2] = Math.min(prevMin2, prevMin1) + current[2];
        }

        // 최댓값과 최솟값 계산
        int max = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
        int min = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));

        // 결과 출력
        System.out.println(max + " " + min);
    }
}

