package sparta.day5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문제는 K 만큼 pop 을 하고 마지막 수를 출력하고 나머지는 다시 큐에 되돌리면 되는 간단한 문제지만
        // 남은 수의 개수가 K보다 작을 때가 고민되었다.
        // 왜냐면 마지막 문자열엔 , 을 안찍기때문이다. 이를 가장 효율적인 방법이 있을까
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (list.size() > 1) { // 1보다 크면 남은 요소가 하나라 그냥 출력하면 된다.
            index = (index + (K - 1)) % list.size(); // index 는 현재 위치이다. K 만큼 이동하면 되는데 리스트는 0부터 시작이기때문에 -1을 해준다.
            // 또한 범위를 초과하면 안되기때문에 list.size 로 나눠준다.
            // 만약 예제대로 K가 3이라면 index 는 2->5->8식으로 증가하는데 8이면 리스트의 크기를 초과한다.
            // 예제에서는 이런경우 원이기때문에 다시 처음으로 돌아간다. 처음으로 돌아가는건 size 로 나누는 것과 같다.

            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove()).append(">"); // 마지막 요소 출력
        System.out.println(sb);
    }
}


