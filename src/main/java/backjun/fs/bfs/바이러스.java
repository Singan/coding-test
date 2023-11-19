package backjun.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int line = sc.nextInt();
        boolean[] check = new boolean[number+1];
        int[][] relation = new int [number+1][number+1];
        for (int i = 0 ;i<line;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            relation[n][m] = 1;// 두 선의 연결
            relation[m][n] = 1;// 두 선의 연결
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 1번 컴퓨터부터 시작하므로 1을 담음
        check[1] = true; // 1번 컴퓨터를 다시 방문하지 않기 위해 체크
        int result = 0;
        while (!q.isEmpty()){
            int cur = q.poll(); // 처음 1
            for (int i = 0 ;i<relation[cur].length;i++){ // 1번과 연결된 컴퓨터를 찾아야 함
                if(relation[cur][i]==1 && !check[i]){ // 1이면 연결이 되있다는 뜻
                    q.offer(i); // 찾았다면 추가로 이어진 컴퓨터를 찾아야 하기 때문에 큐에 담음
                    check[i] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
