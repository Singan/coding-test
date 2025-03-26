class Solution {
    public int solution(String name) {
        int totalMove = 0;
        int n = name.length();

        // 각 알파벳에 대해 조작 횟수 더하기
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            // A와의 차이를 계산해서 최소값을 더함
            totalMove += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 커서 이동 최적화
        int minCursorMove = n - 1;  // 커서가 오른쪽으로만 이동하는 경우 (최대 n-1번 이동)

for (int i = 0; i < n; i++) {
    int nextIndex = i + 1;
    // 오른쪽으로만 이동하는 경우를 최적화
    while (nextIndex < n && name.charAt(nextIndex) == 'A') {
        nextIndex++;
    }
    // 커서를 이동시키는 최적화 방법
    minCursorMove = Math.min(minCursorMove, i + n - nextIndex + Math.min(i, n - nextIndex));
}

        return totalMove + minCursorMove;
    }
}