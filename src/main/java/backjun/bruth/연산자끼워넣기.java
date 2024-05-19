package backjun.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    static int n;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int op = Integer.parseInt(st.nextToken(" "));
            operator[i] = op;
        }
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int depth, int num) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i] -= 1;
                int nextNum = arr[depth];
                switch (i) {
                    case 0:
                        nextNum += num;
                        break;
                    case 1:
                        nextNum = num - nextNum;
                        break;
                    case 2:
                        nextNum *= num;
                        break;
                    case 3:
                        nextNum = num / nextNum;
                        break;
                }
                dfs(depth + 1, nextNum);
                operator[i] += 1;
            }
        }
    }
}
