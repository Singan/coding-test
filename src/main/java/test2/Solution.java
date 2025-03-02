package test2;

public class Solution {

    public static void main(String[] args) {
        int x = 11;  // 총 후원자 수
        int y = 22000;  // 총 후원 금액

        distributeDonations(9, 22000);
        distributeDonations(11, 50000);
        distributeDonations(3, 15000);
        distributeDonations(5, 30000);

    }

    public static void distributeDonations(int x, int y) {
        // 각 금액대 후원자 수 초기화
        int tenThousand = 0;
        int fiveThousand = 0;
        int thousand = 0;

        // 10000원 후원자 수 최대한으로 계산
        tenThousand = Math.min(y / 10000, x);  // 최대 10000원 후원자 수는 x명까지
        y -= tenThousand * 10000; // 남은 금액
        x -= tenThousand; // 남은 후원자 수

        // 5000원 후원자 수 최대한으로 계산
        fiveThousand = Math.min(y / 5000, x);  // 최대 5000원 후원자 수는 남은 후원자 수 x명까지
        y -= fiveThousand * 5000; // 남은 금액
        x -= fiveThousand; // 남은 후원자 수

        // 1000원 후원자 수 최대한으로 계산
        thousand = Math.min(y / 1000, x);  // 최대 1000원 후원자 수는 남은 후원자 수 x명까지
        y -= thousand * 1000; // 남은 금액
        x -= thousand; // 남은 후원자 수

        // 배분이 정확한지 확인
        if (y == 0 && x == 0) {
            System.out.println("10000원 후원자 수: " + tenThousand);
            System.out.println("5000원 후원자 수: " + fiveThousand);
            System.out.println("1000원 후원자 수: " + thousand);
        } else {
            System.out.println("해당 조건에 맞는 후원자 배분이 불가능합니다.");
        }
    }
}