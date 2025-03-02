package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 팀빌딩 {

    // 조의 수 n/k
    // i 는 점수 nI 는 해당 점수의 인원
    // 모든 조의 max - min 값을 더했을 때 최대 값이 나와야 함
    // 8 10 4
    //1
    //0
    //0
    //0
    //0
    //4
    //0
    //2
    //0
    //0
    //1
    // 답 = 12

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String [] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        List<Integer> heap = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            int nI = Integer.parseInt(br.readLine());
            for (int j = 0; j < nI; j++) {
                heap.add(i);
            }
        }
        Collections.sort(heap);

        int result = 0;
        for (int i = 0; i < n/k; i++) {
            int last = heap.size() - 1;
            int min = heap.get(0);
            int max = heap.get(last);
            heap.remove(0);
            heap.remove(last);
            result += max - min;
        }

        System.out.println(result);
    }
}
