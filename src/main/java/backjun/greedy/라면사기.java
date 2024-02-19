package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 라면사기 {
    //라면매니아 교준이네 집 주변에는 N개의 라면 공장이 있다.
    // 각 공장은 1번부터 N번까지 차례대로 번호가 부여되어 있다. 교준이는 i번 공장에서 정확하게 Ai개의 라면을 구매하고자 한다(1 ≤ i ≤ N).
    //
    //교준이는 아래의 세 가지 방법으로 라면을 구매할 수 있다.
    //
    //i번 공장에서 라면을 하나 구매한다(1 ≤ i ≤ N). 이 경우 비용은 3원이 든다.
    //i번 공장과 (i+1)번 공장에서 각각 라면을 하나씩 구매한다(1 ≤ i ≤ N-1). 이 경우 비용은 5원이 든다.
    //i번 공장과 (i+1)번 공장, (i+2)번 공장에서 각각 라면을 하나씩 구매한다(1 ≤ i ≤ N-2). 이 경우 비용은 7원이 든다.
    //최소의 비용으로 라면을 구매하고자 할 때, 교준이가 필요한 금액을 출력하는 프로그램을 작성하시오.
    //
    //입력
    //첫 번째 줄에 라면 공장의 개수를 의미하는 자연수 N가 주어진다.
    //
    //두번째 줄에 N개의 정수 A1, ···, AN가 사이에 공백을 두고 주어진다.
    //모든 입력 데이터는 다음 조건을 만족한다.
    //
    //3 ≤ N ≤ 104
    //0 ≤ Ai ≤ 104 (1 ≤ i ≤ N)
    static int[] factory;
    static int value[] = new int[]{3, 2, 2};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        factory = new int[n];

        for (int i = 0; i < n; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (factory[i] > 0) {
                result +=  nextFactory(i, 0, 10 * 10 * 10 * 10 * 10);
                System.out.println(result);
            }
        }
        System.out.println(result);
    }

    public static int nextFactory(int i, int idx, int count) {
        if (i+idx >= n || idx >= value.length || factory[i + idx] == 0)
            return 0;

        count = Math.min(factory[i + idx], count);
        System.out.println(i +"  : " + count);
        factory[i + idx] = factory[i + idx] - count;
        int money = count * value[idx];
        money += nextFactory(i, idx + 1, count);

        return money;
    }

}
