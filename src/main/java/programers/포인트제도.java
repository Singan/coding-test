package programers;

import java.awt.*;
import java.util.*;
import java.util.List;

public class 포인트제도 {
//    public static void main(String[] args) {
//        포인트제도 solver = new 포인트제도();
//
//        String[] answer = solver.solution(new String[]{"a -", "b a", "c b", "d c", "e d", "f d"}, 500);
//
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
//    }
//
//    public String[] solution(String[] members, int p) {
//
//
//        Map<String, String> membersMap = new HashMap();
//        Map<String, Integer> membersIndex = new HashMap();
//        int[] points = new int[members.length];
//        for (int i = 0; i < members.length; i++) {
//            String memberStrArr[] = members[i].split(" ");
//            membersMap.put(memberStrArr[0], memberStrArr[1]);
//            membersIndex.put(memberStrArr[0], i);
//
//            String next = memberStrArr[1];
//            float j = 1;
//
//            while (!next.equals("-")) {
//                int nextIndex = membersIndex.get(next);
//                next = membersMap.get(next);
//                points[nextIndex] = points[nextIndex] + (int) (p * j);
//                j = j / 10;
//            }
//        }
//
//        PriorityQueue<String> pq = new PriorityQueue<String>(
//                (o1, o2) -> Integer.parseInt(o2.split(" ")[1]) -
//                        Integer.parseInt(o1.split(" ")[1]));
//        for (int i = 0; i < members.length; i++) {
//            pq.add(members[i].split(" ")[0] + " " + points[i]);
//        }
//
//        return pq.toArray(new String[pq.size()]);
//    }
public String[] solution(String[] enrollments, int initialPoints) {
    // 추천인과 가입자 관계를 저장할 Map
    Map<String, String> recommendations = new HashMap<>();
    // 각 사람의 포인트를 저장할 Map
    Map<String, Integer> points = new HashMap<>();
    // 모든 사람의 리스트 (가입 순서대로)
    List<String> members = new ArrayList<>();

    // 초기화: 각 사람을 포인트 0으로 시작
    for (String enrollment : enrollments) {
        String[] parts = enrollment.split(" ");
        String person = parts[0];
        String referrer = parts[1];
        recommendations.put(person, referrer);
        members.add(person);
        points.put(person, 0);
    }

    // 각 사람에 대해 포인트 분배
    for (String person : members) {
        distributePoints(person, initialPoints, recommendations, points);
    }

    // 포인트를 내림차순으로 정렬 (포인트 같으면 가입 순서대로)
    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(points.entrySet());
    sortedList.sort((a, b) -> {
        if (b.getValue() == a.getValue()) {
            // 포인트가 같으면 가입 순서대로
            return members.indexOf(a.getKey()) - members.indexOf(b.getKey());
        }
        return b.getValue() - a.getValue();
    });

    // 결과 배열 생성
    String[] result = new String[sortedList.size()];
    for (int i = 0; i < sortedList.size(); i++) {
        result[i] = sortedList.get(i).getKey() + " " + sortedList.get(i).getValue();
    }

    return result;
}

    // 포인트를 분배하는 함수
    private void distributePoints(String person, int pointsToDistribute, Map<String, String> recommendations, Map<String, Integer> points) {
        if (pointsToDistribute < 1) {
            return;
        }

        String referrer = recommendations.get(person);
        if (referrer.equals("-")) {
            return; // 추천인이 없으면 종료
        }

        int referrerPoints = pointsToDistribute / 10;
        points.put(referrer, points.get(referrer) + referrerPoints);

        // 추천인의 추천인에게 포인트 분배
        distributePoints(referrer, referrerPoints, recommendations, points);
    }

    public static void main(String[] args) {
        포인트제도 solver = new 포인트제도();
        String[] answer = solver.solution(new String[]{"a -", "b a", "c b", "d c", "f d", "e d"}, 500);
        System.out.println(Arrays.toString(answer));  // ["d 1250", "c 700", "b 450", "e 250", "f 250", "a 0"]
    }
}
