package sparta.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강그라운드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 지역의 수
        int range = Integer.parseInt(str[1]); // 탐색 범위
        int roads = Integer.parseInt(str[2]); // for 문 반복 횟수

        int arr[][] = new int[n + 1][n + 1];
        int items[] = new int[n + 1];
        String[] itemsStr = br.readLine().split(" ");
        for (int i = 0; i < itemsStr.length; i++) {
            items[i + 1] = Integer.parseInt(itemsStr[i]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    arr[i][j] = 16; // 최대값
                }
            }
        }

        for (int i = 0; i < roads; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arr[a][b] = dis;
            arr[b][a] = dis;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int count = 0;
            for (int j = 1; j < arr[i].length; j++) {
                if (range >= arr[i][j]) {
                    count += items[j];
                }
            }
            max = Math.max(max , count);
        }
        System.out.println(max);

    }
}
