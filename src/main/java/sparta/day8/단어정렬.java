package sparta.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
// 입력 : 첫째 줄에 단어의 개수 N이 주어진다.
// (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
// 주어지는 문자열의 길이는 50을 넘지 않는다.
// SET 을 통해 문자열을 받은 후 SET은 순서를 보장하지 않기때문에
// List 로 변환한 후 정렬한다.
public class 단어정렬 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        TreeSet<String> set = new TreeSet<>();
//        for (int i = 0; i < n ; i++) {
//            String word = br.readLine();
//            set.add(word);
//        }
//        List<String> tempSet = new ArrayList<>(set);
//        Collections.sort(tempSet,(o1, o2) -> {
//            if(o1.length() != o2.length()){
//                return o1.length() - o2.length();
//            }
//            return o1.compareTo(o2);
//        });
//        for (String str : tempSet) {
//            System.out.println(str);
//        }
//
//    }
    public static void main(String[] args) throws IOException { // 풀이 2
        // String 배열로 풀어보기
        // 만약 정렬을 한다면 같은 단어는 바로 앞뒤로 배치될 것이다. 즉 이 단어가 다음 단어와 같다면 출력하지 않으면 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            arr[i] = word;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });
        for (int i = 0; i < arr.length; i++) {
            if (i+1 == arr.length||!arr[i].equals(arr[i + 1]))
                sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
