package sparta.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러 {
    //김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에,
    // 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
    //
    //오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
    // TreeMap 을 이용해서 가장 큰 값을 가진 키를 출력하면 될 것 같았지만
    // TreeMap 은 키를 기준으로 정렬하기에 값으로 정렬할 수 없다.
    // 먼저 HashMap 에 책을 담으며 최대 값을 구한 후
    // HashMap 에서 최대값으로 키를 찾은 후 해당 키들을 정렬하면 될 것같다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Integer value = books.getOrDefault(str, 0);
            books.put(str, value + 1);
            if (max < value + 1) {
                max = value + 1;
            }
        }


        List<Map.Entry<String, Integer>> entries = new ArrayList<>(books.entrySet());

        SortedSet<String> newBooks = new TreeSet<>();
        for (; 0 < entries.size(); ) {
            Map.Entry<String,Integer> entry = entries.get(0);
            if (entry.getValue() == max) {
                newBooks.add(entry.getKey());
            }
            entries.remove(0);
        }

        System.out.println(newBooks.first());

    }
}
