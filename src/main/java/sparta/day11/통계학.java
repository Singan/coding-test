package sparta.day11;

import java.util.*;

public class 통계학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] frequency = new int[8001]; // -4000 ~ 4000 범위의 정수를 처리할 배열
        int sum = 0, maxFreq = 0, mode = 0, modeCount = 0;
        boolean secondMode = false;

        // 입력 처리
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            sum += num;
            frequency[num + 4000]++; // 입력값을 배열 index로 맞춤
        }

        // 배열 정렬 (중앙값 구하기 위해)
        Arrays.sort(arr);

        // 산술평균 계산 및 출력
        System.out.println(Math.round((float) sum / n));

        // 중앙값 출력
        System.out.println(arr[n / 2]);

        // 최빈값 찾기
        for (int i = 0; i < 8001; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                mode = i - 4000; // 최빈값 저장
                secondMode = false;
                modeCount = 1;
            } else if (frequency[i] == maxFreq) {
                if (!secondMode) {
                    mode = i - 4000; // 두 번째로 작은 최빈값 저장
                    secondMode = true;
                }
            }
        }
        System.out.println(mode);

        // 범위 출력
        System.out.println(arr[n - 1] - arr[0]);
    }
}
