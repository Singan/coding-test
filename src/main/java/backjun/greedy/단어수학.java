package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.*;

public class 단어수학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] strArr = new String[count];
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            strArr[i] = str;
            queue.add(str);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (String str : strArr) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) +
                        ((int) Math.pow(10, str.length() - i - 1))
                );
            }
        }
        HashMap<Character, Integer> charToNum = new HashMap<>();
        List<Map.Entry<Character,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int number = 9;
        for (Map.Entry<Character, Integer> entry : entryList) {
            charToNum.put(entry.getKey(), number);
            number--;
        }
        int sum = 0;

        for (int i = 0; i < strArr.length; i++) {
            StringBuffer sb = new StringBuffer();
            String str = strArr[i];
            int length = str.length();
            for (int j = 0; j < length ; j++) {
                sb.append(charToNum.get(str.charAt(j)));
            }
            sum+= Integer.parseInt(sb.toString());
        }
        System.out.println(sum);
    }
}
