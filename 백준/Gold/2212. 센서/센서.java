
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2212
// 1,3 사이에 센서를 배치했을 때 수신 거리는 2가 된다.
// 센서를 6과 9 사이에 배치하면 수신거리는 3이 된다. 6과 9 중간에 있기에 상관없다.
//1 6 9 3 6 7 -> 1 3 6 6 7 9
// 이렇게 배치할 시 3과 6 사이에 3이라는 가장 큰 빈 공간이 생긴다.
// 이걸 없애야 한다. 예제는 k=2 이기때문에 집중국을 두 개 세울 수 있다.
// 즉 2분할 할 수 있다. 즉 없앨 수 있는 가장 큰 빈 공간의 수는 k-1 이다.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());// 가장 큰 빈 공간을 찾기 위해
        for (int i = 0; i < arr.length - 1; i++) {
            queue.add(arr[i + 1] - arr[i]);
        }
        for (int i = 0; i < k - 1; i++) { // 제거할 빈 공간을 꺼낸다.
            queue.poll();
        }
        int total = 0;
        while(!queue.isEmpty()){
            total+=queue.poll();
        }
        System.out.println(total);
    }
}
