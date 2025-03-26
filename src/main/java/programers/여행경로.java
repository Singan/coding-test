package programers;

import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        여행경로 solver = new 여행경로();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solver.solution(tickets))); // 예상 출력: ["ICN", "JFK", "HND", "IAD"]
    }

    HashMap<String,  PriorityQueue<String>> hashMap;
    static List<String> answer = new ArrayList();

    public String[] solution(String[][] tickets) {
        hashMap = new HashMap();
        for (String[] ticket : tickets) {
            hashMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            hashMap.get(ticket[0]).add(ticket[1]);
        }
        dfs("ICN");
        Collections.reverse(answer);

        return answer.toArray(new String[answer.size()]);
    }

    public void dfs(String airport) {
        PriorityQueue<String> queue = hashMap.get(airport);

        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        answer.add(airport);

    }
}
