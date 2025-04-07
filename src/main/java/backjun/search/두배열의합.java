package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 목표값
        int a = Integer.parseInt(br.readLine());
        int aArr[] = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aArr.length; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        int b = Integer.parseInt(br.readLine());
        int bArr[] = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> aSums = new ArrayList<>();
        List<Integer> bSums = new ArrayList<>();
        for (int i = 0; i < aArr.length; i++) {
            int number = 0;
            for (int j = i; j < aArr.length; j++) {
                number += aArr[j];
                aSums.add(number);
            }
        }
        for (int i = 0; i < bArr.length; i++) {
            int number = 0;
            for (int j = i; j < bArr.length; j++) {
                number += bArr[j];
                bSums.add(number);
            }
        }
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < aSums.size(); i++) {
            aMap.put(aSums.get(i), aMap.getOrDefault(aSums.get(i), 0) + 1);
        }
        int count = 0;
        for (int sum : bSums) {
            int target = T - sum;
            if (aMap.containsKey(target)) {
                count += aMap.get(target);
            }
        }
        System.out.println(count);
    }
}
