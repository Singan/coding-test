import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] strArr = new String[count];
        for (int i = 0; i < count; i++) {
            strArr[i] = br.readLine();
        }

        // 자릿값 계산을 위한 맵
        Map<Character, Integer> weightMap = new HashMap<>();
        for (String str : strArr) {
            int power = 1;  // 1의 자리부터 시작
            for (int i = str.length() - 1; i >= 0; i--) {
                char ch = str.charAt(i);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + power);
                power *= 10;  // 다음 자릿값으로 이동
            }
        }

        // 자릿값이 큰 문자부터 높은 숫자 매칭
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(weightMap.entrySet());

        int value = 9;
        Map<Character, Integer> numberMap = new HashMap<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            numberMap.put(entry.getKey(), value--);
        }

        // 최종 계산
        int sum = 0;
        for (String str : strArr) {
            int num = 0;
            for (char ch : str.toCharArray()) {
                num = num * 10 + numberMap.get(ch);
            }
            sum += num;
        }

        System.out.println(sum);
    }
}
