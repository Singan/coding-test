package sparta.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17207
public class 돌려막기 {

    final static String[] names = new String[]{"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 일의 난이도 배열
        int jobs[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                jobs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 일의 소요 시간 배열
        int times[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                times[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // x 번 째 사람의 y 번째 예상 일량 = jobs[i][j] * times[j][y]

        int[] arr = new int[5];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int job = jobs[i][j];
                for(int y = 0 ; y<5 ; y++){
                    int time = times[j][y];
                    arr[i] += job*time;
                }
            }
            if(min>=arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }
        System.out.println(names[minIndex]);
    }
}
