package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int left = 0;
        int right = n;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

        }

    }
}
