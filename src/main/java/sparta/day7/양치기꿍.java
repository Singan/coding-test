package sparta.day7;
//https://www.acmicpc.net/problem/3187

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 입력 : 빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k'
// 입력에 공백이 없기 때문에 charAt 으로 해도 무방할 것 같다.
// 첫 줄에 세로, 가로 칸의 수
// 로직 : 칸들을 탐색하며 k,또는 v 를 만나면 로직을 실행한다.
// 칸을 이동하여 k 와 v 가 얼마나 있는지 확인 후 더 많은 쪽의 값을 양 또는 늑대에 더한다.
// 만약 #을 만나면 다음 로직을 실행하지 않는다.
// 그렇게 완전히 로직이 끝난다면 k 와 v 의 값을 비교해서 더 큰 값을 k 또는 v 에 해당하는 배열에 더한다.
// 로직이 완전히 끝나면 더하기 위해서 로직이 시작할 때 new 배열을 새로 만든다. for 문 안에서 생성되기에 로직이 끝나면 다음 로직때 초기화된다.
public class 양치기꿍 {
    static char arr[][];
    static int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//상하좌우
    static boolean visit[][];

    static int[] count ; // bfs 용 임시 배열
    static int[] result = new int[2];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        visit = new boolean[x][y];
        arr = new char[x][y];
        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ((arr[i][j] == 'v' || arr[i][j] == 'k') && !visit[i][j]) {
                    count = new int[2];
                    bfs(i, j);
                    if(count[0] < count[1]){
                        result[1]+=count[1];
                    }else{
                        result[0]+=count[0];
                    }
                }
            }
        }
        System.out.println(result[1] + " " + result[0]);

    }

    static void bfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            visit[cur[0]][cur[1]] = true;
            char ch = arr[cur[0]][cur[1]];

            switch (ch){ // v 늑대 , k 양 , 0 늑대 1 양
                case 'v':
                    count[0] +=1;
                    break;
                case 'k':
                    count[1] +=1;
                    break;
            }


            for (int[] m : move) {
                int nextX = cur[1]+ m[1];
                int nextY = cur[0]+ m[0];
                if (nextY >= 0 && nextY < arr.length && nextX >= 0 && nextX < arr[0].length
                        && !visit[nextY][nextX] && arr[nextY][nextX] != '#') {
                    bfs(nextY , nextX);
                }
            }
        }
    }
}
