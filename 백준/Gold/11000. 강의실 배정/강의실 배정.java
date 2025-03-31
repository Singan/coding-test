import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int arr[][] = new int[count][2];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int endTime = 0;
        PriorityQueue<Integer> queues = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            if (queues.isEmpty()) {
                queues.add(arr[i][1]);
                continue;
            }
            if (arr[i][0] >= queues.peek()){
                queues.poll();
            }
            queues.add(arr[i][1]);
        }

        System.out.println(queues.size());
    }
}
