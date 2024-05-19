package backjun.bruth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 로또 {
    //독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
    //
    //로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
    //
    //예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
    // ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
    //
    //집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
    //
    //입력
    //입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 수는 k (6 < k < 13)이고,
    // 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
    //
    //입력의 마지막 줄에는 0이 하나 주어진다.
    static int[] arr;
    static boolean[] visit;
    static int k;
    static final int n = 6;
    static int[] bufArr;
    static StringBuffer sb ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str[] = br.readLine().split(" ");
            k = Integer.parseInt(str[0]);
            sb = new StringBuffer();
            if (k == 0)
                break;

            arr = new int[k];
            visit = new boolean[k];
            bufArr = new int[n];
            for (int i = 1; i < str.length; i++) {
                arr[i - 1] = Integer.parseInt(str[i]);
            }
            dfs(0 , 0);
            System.out.println(sb.toString());
        }

    }

    public static void dfs(int depth , int index) {
        if (depth == bufArr.length) {
            for (int value : bufArr){
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                bufArr[depth] = arr[i];
                dfs(depth + 1 , i );
                visit[i] = false;
            }
        }
    }
}
