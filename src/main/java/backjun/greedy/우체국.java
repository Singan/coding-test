package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class 우체국 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        long total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            String[] str = br.readLine().split(" ");
            int village = Integer.parseInt(str[0]);
            int people = Integer.parseInt(str[1]);

            map.put(village, people);
            total += people;
        }
        total = total / 2 + total % 2;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey() < o2.getKey() ? -1 : 1).collect(Collectors.toCollection(LinkedHashSet::new));
        long chk = 0;
        int result = 0;
        for (Map.Entry entry : set) {
            chk = chk + (int)entry.getValue();
            System.out.println(chk);
            if (total <= chk) {
                result = (int) entry.getKey();
                break;
            }
        }
        System.out.println(result);
    }
}
