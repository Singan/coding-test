
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // HashSet을 사용하여 A 배열의 값을 저장합니다.
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            int searchValue = Integer.parseInt(st.nextToken());
            // HashSet에서 값을 검색하여 존재 여부를 출력합니다.
            if (set.contains(searchValue)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        // 결과를 출력합니다.
        System.out.print(sb.toString());
    }
}
