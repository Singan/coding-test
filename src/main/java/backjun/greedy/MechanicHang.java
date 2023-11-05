package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MechanicHang {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] l = new int[count];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(l);
        int min = l[0] + length - 1;
        int result = 1;
        for (int i = 1; i < l.length; i++) {
            if (l[i] <= min) {
                continue;
            }
            result++;
            min = l[i]+length - 1;
        }
        System.out.println(result);
    }
}
