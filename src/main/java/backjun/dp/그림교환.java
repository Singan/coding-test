package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그림교환 {
    //예술을 사랑하는 사람들이 시장에 모여서 그들의 그림을 서로 거래하려고 한다.
    // 모든 그림의 거래는 다음과 같은 조건을 만족해야 한다.
    //
    //그림을 팔 때, 그림을 산 가격보다 크거나 같은 가격으로 팔아야 한다.
    //같은 그림을 두 번 이상 사는 것은 불가능하다.
    //방금 시장에 새로운 그림이 들어왔다. 1번 아티스트는 그 그림을 외부 상인에게 가격 0을 주고 샀다.
    // 이제 그 그림을 자신의 예술가 친구들에게 팔려고 한다.
    // 위의 조건을 모두 만족하는 거래만 이루어진다고 가정했을 때, 그림을 소유했던 사람의 수의 최댓값을 출력하는 프로그램을 작성하시오.
    // (1번 아티스트와 마지막으로 그 그림을 소유한 사람도 포함한다).
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

    }
}
