package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질4 {
    //수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    // 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
    //
    //수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if (start > end) {
            System.out.println(start - end);
            for (int i = start; i >= end; i--) {
                System.out.print(i + " ");
            }
            return;
        }else if(start == end){
            System.out.println(0);
            System.out.println(end);
        }

        int arr[][] = new int[100001][2];
        Queue<Integer> q = new LinkedList<>();
        //----------------------------- 세팅-----------------
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                arr[end][0] = Math.max(arr[end][0], arr[cur][0]);
                arr[end][1] = arr[cur][1];
            } else {
                int next = cur + 1;
                int prev = cur - 1;
                int mul = cur * 2;
                int[] move = {next, prev, mul};
                for (int m : move) {
                    if ((m >= 0 && m < arr.length) && (arr[m][0] > arr[cur][0] + 1 || arr[m][0] == 0)) {
                        arr[m][0] = arr[cur][0] + 1;
                        arr[m][1] = cur;
                        q.add(m);
                    }
                }
            }
        }
        // ------------------------------- bfs -------------

        System.out.println(arr[end][0]);
        int next = end;
        String result = "" + next;
        while (next != start) {
            next = arr[next][1];
            result = next + " " + result;
        }
        System.out.println(result);
    }
}