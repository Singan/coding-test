package sparta.day6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
// 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
// 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.


// 로직 : 옷의 이름은 중요하지 않고 옷의 종류만 필요하다. ( 옷의 이름은 중복이 없기 때문)
// 옷의 종류와 개수만 구해 경우의 수를 구하면 된다. 입지 않는 경우는 제외기 때문에 -1 해준다.
// 맵에 키가 들어간다는건 해당 종류의 옷이 있다는 것이다. 옷이 있다는 건 해당 옷을 입지 않는 경우의 수가 생기는 것이라 옷의 수 +1을 해줘야한다.
// 총 경우의 수 = (k1 +1) * (k2+1) ***   - 1
public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                map.put(key , map.getOrDefault(key,1)+1 );
            }
            int result = 1;
            for (int value : map.values()){
                result *=value;
            }
            System.out.println(result-1);
        }
    }
}
