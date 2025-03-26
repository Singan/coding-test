
import java.util.*;

class Solution {
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