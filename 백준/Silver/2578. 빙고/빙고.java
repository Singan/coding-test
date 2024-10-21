
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[5][5];
        boolean visited[][] = new boolean[5][5];

        for (int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int count = 0;
        wo:
        for (int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                int value = Integer.parseInt(str[j]);
                count++;
                for (int k = 0; k < arr.length; k++) {
                    for (int l = 0; l < arr[k].length; l++) {
                        if (value == arr[k][l]) {
                            visited[k][l] = true;
                            if (chk(visited)) {
                                System.out.println(count);
                                return;

                            }

                        }
                    }
                }
            }
        }

    }

    static boolean chk(boolean[][] visited) {
        // 각 끝의 시작점 x가 0이거나 y 가 0인 경우만 체크하면 된다.
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            boolean chk = true;
            for (int j = 0; j < visited[i].length; j++) {// 세로 빙고 확인
                if (!visited[j][i]) {
                    chk = false;
                    break;
                }
            }

            if (chk)
                count++;
            chk = true;
            for (int j = 0; j < visited[i].length; j++) {// 가로
                if (!visited[i][j]) {
                    chk = false;
                    break;
                }
            }
            if (chk)
                count++;
        }
        boolean chk = true;
        for (int j = 0; j < visited[0].length; j++) {// 대각 빙고 확인
            if (!visited[j][j]) {
                chk = false;
            }

        }
        if (chk)
            count++;

        // 역대각 표현
        chk = true;
        for (int j = visited[0].length - 1; j >= 0; j--) {

            if (!visited[j][4 - j]) {
                chk = false;
                break;
            }

        }
        if (chk)
            count++;

        return count >= 3;
    }
}
