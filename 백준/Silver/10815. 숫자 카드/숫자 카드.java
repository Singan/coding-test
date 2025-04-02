import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int myCard[] = new int[n];
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            myCard[i] = Integer.parseInt(st.nextToken());
            set.add(myCard[i]);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int cardArr[] = new int[m];
        int answer[] = new int[m];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
            answer[i] = set.contains(cardArr[i]) ? 1 : 0;
            sb.append(answer[i] + " ");
        }

        System.out.println(sb.toString());

    }
}
