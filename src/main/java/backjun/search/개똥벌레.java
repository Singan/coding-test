package backjun.search;

import java.io.IOException;

import java.io.*;
import java.util.*;

public class 개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄 입력: N과 H
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 장애물의 수
        int H = Integer.parseInt(st.nextToken()); // 높이

        // 석순과 종유석을 나눠서 저장할 배열
        int[] bottom = new int[H + 1]; // 석순 (아래에서 자라는 장애물)
        int[] top = new int[H + 1];    // 종유석 (위에서 내려오는 장애물)

        // N개의 장애물 크기 입력
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bottom[size]++; // 석순
            } else {
                top[size]++; // 종유석
            }
        }
        int sums[] = new int[H + 1];
        sums[1] = N - (N / 2) + top[H];
        for (int i = 2; i <= H; i++) {
            sums[i] = (sums[i - 1] - bottom[i - 1]);// 석순의 개수 높이가 1인 석순은 1 구간으로 돌파가 된다.
            // 즉 2 구간을 돌파하는 1구간을 돌파하는 석순에서 높이가 1인 석순을 제거하면 된다.
            // 종유석의 개수는 높이가 H - i + 1 까지의 종유석을 돌파하게 된다
            // 2 구간을 돌파하는 종유석은 높이가 4, 5인 종유석
            sums[i] += top[H - i + 1];
        }
        Arrays.sort(sums);

        int min = sums[1];
        int count = 1;

        for (int i = 2; i <=H; i++) {
            if(sums[i] > min) break;
            count++;
        }

        System.out.println(min + " " + count);

    }
}
