package backjun.etc;

import java.util.Scanner;

public class ZOAC4 {
//    2021년 12월, 네 번째로 개최된 ZOAC의 오프닝을 맡은 성우는 오프라인 대회를 대비하여 강의실을 예약하려고 한다.
//    강의실에서 대회를 치르려면 거리두기 수칙을 지켜야 한다!
//    한 명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐 있을 때, 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다. 즉,
//    다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
//    논문과 과제에 시달리는 성우를 위해 강의실이 거리두기 수칙을 지키면서 최대 몇 명을 수용할 수 있는지 구해보자.
//    입력
//    H, W, N, M이 공백으로 구분되어 주어진다. (0 < H, W, N, M ≤ 50,000)
//
//    출력
//    강의실이 수용할 수 있는 최대 인원 수를 출력한다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int H = scanner.nextInt();
        final int W = scanner.nextInt();
        final int N = scanner.nextInt();
        final int M = scanner.nextInt();
        int columnPeople = H/(N+1);
        int column = H%(N+1)==0 ? columnPeople:columnPeople+1;
        int rowPeople = W/(M+1);
        int row = W%(M+1)==0 ? rowPeople:rowPeople+1;
        System.out.println(column*row);


    }
}
