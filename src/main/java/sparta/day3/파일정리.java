package sparta.day3;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/20291

//정렬이 된 데이터가 필요함으로 HashMap 보다 TreeMap 이 성능에서 좋았다.
public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> extensions = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String extension = str.substring(str.lastIndexOf(".") + 1);
            Integer value = extensions.getOrDefault(extension, 0);
            extensions.put(extension, value + 1);
        }
//        Set<Map.Entry<String, Integer>> entrySet = extensions.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
//        // 키 값으로 오름차순 정렬
//        while (it.hasNext()) {
//            Map.Entry<String, Integer> cur = it.next();
//            String key = cur.getKey();
//            Integer value = cur.getValue();
//            bw.write(key+ " " + value+"\n");
//        }
//        bw.flush();
        // stream 으로 바꿔보기
        extensions.entrySet().stream().forEach(cur -> {
                    String key = cur.getKey();
                    Integer value = cur.getValue();
                    try {
                        bw.write(key + " " + value + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        bw.flush();
    }
}
