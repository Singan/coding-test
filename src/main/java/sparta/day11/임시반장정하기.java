package sparta.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 임시반장정하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][5]; // 각 인원의 학년별 반
        boolean chk[][] = new boolean[n][n]; // 각 인원이 같은반을 했던 인원 수

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = i + 1; k < n; k++) {
                    if (arr[i][j] == arr[k][j]) {
                        chk[i][k] = true;
                        chk[k][i] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if(chk[i][j]) count++;
            }
            if (max < count) {
                max = count;
                maxIndex = i;
            }
        }


        System.out.println(maxIndex + 1);


    }
}
