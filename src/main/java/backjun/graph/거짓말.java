package backjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 거짓말 {
    //첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
    //
    //둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다. 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다.
    // 사람들의 번호는 1부터 N까지의 수로 주어진다.
    //
    //셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
    //
    //N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수, 각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int party = Integer.parseInt(str[1]);
        boolean[] know = new boolean[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < Integer.parseInt(str[0]); i++) {

        }


    }
}
