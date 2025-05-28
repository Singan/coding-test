import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄: 크레인의 수 N
        int n = Integer.parseInt(br.readLine());

        // 둘째 줄: 각 크레인의 무게 제한
        Integer[] cranes = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        // 셋째 줄: 박스의 수 M
        int m = Integer.parseInt(br.readLine());

        // 넷째 줄: 각 박스의 무게
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> boxList = new ArrayList();
        for (int i = 0; i < m; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxList, Collections.reverseOrder());
        int result = 0;
        if (boxList.get(0) <= cranes[0]) {
            while (!boxList.isEmpty()) {
                Iterator<Integer> iterator = boxList.iterator();

                for (int i = 0; i < cranes.length; i++) {
                    while (iterator.hasNext()) {
                        int box = iterator.next();
                        if (cranes[i] >= box) {
                            iterator.remove(); // O(1)로 제거 가능
                            break;
                        }
                    }
                }

                result++;
            }
        } else {
            result = -1;
        }

        System.out.println(result);
    }
}
