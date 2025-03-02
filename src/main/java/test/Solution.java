package test;
// 아래 예시와 조건을 참조하여 임의의 입력 값에 대하여, 최하위 노드까지 탐색을 통해 그 값을 모두 찾아 내는 로직을 구현 하세요.
//
//예시
//
//조건
//입력 값을 받아 KEY1의 동일 값을 검색하고 대응되는 복수 개의 KEY2 값을 찾아 다시 KEY1의 값에서 검색하는 과정을 반복하여 더 이상 KEY1 값에 존재하지 않는 노드를 결과 값으로 출력
//10개의 데이터는 변수 KEY1(10), KEY2(10)에 보관되어 있고, 입력 값은 변수 inp에 저장되는 것으로 가정

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String solution(int[] key1, int[] key2, int inp) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(inp);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            boolean flag = false;
            for (int i = 0; i < key1.length; i++) {
                if (cur == key1[i]) {
                    q.offer(key2[i]);
                    flag = true;
                }
            }
            if (!flag) {
                sb.append(cur + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 인자 값은 지원자가 적절하게 수정하여 제출
        System.out.println(
                sol.solution(
                        new int[]{1,1,2,3,3,5,6,6,6,7}, new int[]{2,3,4,5,6,7,8,9,10,11}, 1
                )
        );
    }
}