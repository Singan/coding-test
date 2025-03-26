package programers;

public class 조이스틱 {


    // 알파벳이 A->B->C로 원하는 N에 도달하는게 빠른지 A->Z->X 역행으로 가는게 빠른지 비교해야함
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        // 커서 이동의 최솟값을 구하는 변수
        int minCursorMove = n - 1;

        // 이름의 각 문자에 대해 조작을 최소화하는 방법
        for (int i = 0; i < n; i++) {
            // 각 문자에 대해 ▲▼ 조작
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 오른쪽으로 이동하면서 'A'를 건너뛰는 최적화
            int nextIndex = i + 1;
            // 'A'가 연속된 부분을 건너뛰기
            while (nextIndex < n && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 커서 이동 최적화: 오른쪽으로 가는 방법과 왼쪽으로 가는 방법을 비교
            minCursorMove = Math.min(minCursorMove, i + n - nextIndex + Math.min(i, n - nextIndex));
        }

        return answer + minCursorMove;
    }
}
