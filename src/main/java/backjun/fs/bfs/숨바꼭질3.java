package backjun.fs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
    //수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    // 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    // 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
    //
    //수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        int end = Integer.parseInt(st.nextToken());
        int[] countTime = new int[100001];

        for (int i = 0; i < countTime.length; i++) {
            countTime[i] = Integer.MAX_VALUE;
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        countTime[start] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int curTime = countTime[cur];
            Node leftNode = createNode(cur -1, curTime + 1);
            Node rightNode = createNode(cur +1, curTime + 1);
            Node tellNode = createNode(cur *2, curTime );
            move(leftNode,queue,countTime);
            move(rightNode,queue,countTime);
            move(tellNode,queue,countTime);
        }

        System.out.println(countTime[end]);

    }
    public static void move(Node node,Queue queue, int[] countTime){
        if (0 <= node.location && countTime.length > node.location && countTime[node.location] > node.time) {
            queue.add(node.location);
            countTime[node.location] = node.time;
        }
    }

    public static Node createNode(int location,int time){
        return new Node(location,time);
    }
}
class Node {
    int location;
    int time;

    public Node(int location, int time) {
        this.location = location;
        this.time = time;
    }
}