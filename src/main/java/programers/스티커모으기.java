package programers;

public class 스티커모으기 {

    public static void main(String[] args) {

    }
    public int solution(int sticker[]) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        int n = sticker.length;
        int dp1[]= new int[sticker.length];
        int dp2[] = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            if (i < sticker.length - 1) { // dp1은 마지막 스티커 선택 X
                dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
            }
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        return Math.max(dp1[n - 2], dp2[n - 1]); // 두 가지 경우 중 최댓값 반환

    }
}

