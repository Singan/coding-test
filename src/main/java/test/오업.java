package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;

import java.util.PriorityQueue;

public class 오업 {

    // 업무의 우선순위가 높은대로 나와야 함
    // 우선순위가 같다면 업무 ID 가 작은 순서대로
    // N Q 입력
    // N 개의 줄에 업무 ID 우선순위
    // Q 는 업무 변동사항 (명령문 개수)
    static PriorityQueue<Work> pq = new PriorityQueue<Work>();
    static HashMap<Integer,Work> workMap = new HashMap();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int priority = Integer.parseInt(line[1]);
            int id = Integer.parseInt(line[0]);
            Work work = new Work(priority, id);
            pq.add(work);
            workMap.put(id, work);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");

            switch (line[0]){
                case "WORK":
                    pq.poll();
                    break;
                case "INSERT":
                    int id = Integer.parseInt(line[1]);
                    int priority = Integer.parseInt(line[2]);
                    Work work = new Work(priority, id);
                    workMap.put(id, work);
                    pq.add(work);
                    break;
                case "CHANGE":
                    int targetId = Integer.parseInt(line[1]);
                    int changePriority = Integer.parseInt(line[2]);
                    Work targetWork = workMap.get(targetId);
                    pq.remove(targetWork);
                    targetWork.priority = changePriority;
                    pq.add(targetWork);
                    break;
            }
            sb.append(output()).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static String output(){
        if(pq.isEmpty())
            return "EMPTY";
        return String.valueOf(pq.peek().id);
    }
    static class Work implements Comparable<Work> {
        int priority;
        int id;

        public Work(int priority, int id) {
            this.priority = priority;
            this.id = id;
        }

        @Override
        public int compareTo(Work o) {
            if (this.priority != o.priority)
                return o.priority - priority;
            return this.id - o.id;
        }
    }
}
