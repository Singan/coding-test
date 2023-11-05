package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewSawon {
    //1946 번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int peopleCount = Integer.parseInt(br.readLine());
            int[] peopleCase = new int[peopleCount];
            StringTokenizer st;
            for (int j = 0; j < peopleCount; j++) {
                st = new StringTokenizer(br.readLine()," ");
                peopleCase[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }
            int number2 = peopleCase[0];
            int result = 1;
            for (int j = 1; j < peopleCount; j++) {
                if (number2 > peopleCase[j]) {
                    result++;
                    number2 = peopleCase[j];
                }
            }
            System.out.println(result);
        }
    }
}
