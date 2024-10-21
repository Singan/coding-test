package sparta.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다.
// 다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다.
// 이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다.
// 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며,
// ** 모든 다리는 양방향이다. **
// A->B 중 최대 중량을 가진 다리를 찾아야 한다.

public class 중량제한 {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int arr[][] = new int[n][n];
        boolean visit[] = new boolean[n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
            arr[b][a] = c;
        }
        str = br.readLine().split(" ");
        int factory1 = Integer.parseInt(str[0]);
        int factory2 = Integer.parseInt(str[1]);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(factory1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < arr[cur].length; i++) {
                if(arr[cur][i]> 0 ){
                    queue.add(i);
                }
            }
        }

    }
}
