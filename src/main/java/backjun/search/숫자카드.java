package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int myCard[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            myCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCard);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int cardArr[] = new int[m];
        int answer[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int targetCard = cardArr[i];
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (targetCard == myCard[mid]) {
                    answer[i] = 1;
                    break;
                }
                if (myCard[mid] < targetCard){
                    start = mid + 1;
                } else {

                    end = mid - 1;
                }
            }
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
