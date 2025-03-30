import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        int[][] List = new int[N][N];
        int[][] temp = new int[N][N];
        
        // 2D 배열 List와 temp 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List[i][j] = sc.nextInt();
                temp[i][j] = 1;  // 기본값은 1로 설정
            }
        }
        
        // LIS 계산을 위한 DP 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        if (List[k][l] < List[i][j]) {
                            temp[i][j] = Math.max(temp[i][j], temp[k][l] + 1);
                        }
                    }
                }
            }
        }

        // 최장 증가 부분 수열(LIS) 길이 계산
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, temp[i][j]);
            }
        }
        
        // 결과 출력
        System.out.println(ans);
        
        sc.close();
    }
}
