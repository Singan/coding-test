import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 입력 : 테스트케이스
// 파일 수
// 파일 크기 . . .
// 파일 크기가 작은 것을 우선으로 계속 더하면 되는 그리디 문제 같다.
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long result = 0; // k 는 최소 3이다.
            while (true){

                long next = queue.poll() + queue.poll();

                result+= next;
                if(queue.isEmpty())
                    break;
                queue.add(next);
            }

            System.out.println(result);
        }
    }
}
