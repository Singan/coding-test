import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[n][m];

        str = br.readLine().split(" ");
        Robot robot = new Robot(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        Board board = new Board(arr);
        start(robot, board);
        System.out.println(board.count);
    }

    public static void start(Robot robot, Board board) {
        // 현재 위치 청소
        if (0 == board.arr[robot.x][robot.y]) {
            board.clean(robot.location());
        }

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            robot.changeDirection();
            if (board.isForward(robot.nextMoveForward())) { // 전진 가능 여부 확인
                robot.moveForward();
                start(robot, board); // 재귀 호출 후 탐색 종료
                return; // 전진했으면 더 이상 탐색하지 않음
            }
        }

        if (board.isBack(robot.nextMoveBack())) {
            robot.moveBack(); // 후진
            start(robot, board); // 후진 후 재귀 호출
        } else {
            // 후진도 불가능하면 작동 멈춤
            return;
        }
    }


    static class Board {
        private final int[][] arr;
        int count = 0;

        public Board(int[][] arr) {
            this.arr = arr;
        }

        public boolean isForward(int[] idx) {
            int i = idx[0];
            int j = idx[1];
            // 배열 경계를 벗어나지 않고 벽이 아니며, 청소되지 않은 칸이 있는지 확인
            return i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] == 0;
        }
        public boolean isBack(int[] idx) {
            int i = idx[0];
            int j = idx[1];
            // 배열 경계를 벗어나지 않고 벽이 아니며, 청소되지 않은 칸이 있는지 확인
            return i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] != 1;
        }
        public void clean(int[] idx) {
            arr[idx[0]][idx[1]] = -1;
            count++;
        }
    }

    static class Robot {
        final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서 방향
        int x;
        int y;
        int direction;

        public Robot(int startX, int startY, int direction) {
            this.x = startX;
            this.y = startY;
            this.direction = direction;
        }

        public int[] nextMoveBack() {
            int backDir = (direction + 2) % 4; // 현재 방향의 반대쪽으로 후진
            return new int[]{x + move[backDir][0], y + move[backDir][1]};
        }

        public int[] nextMoveForward() {
            return new int[]{x + move[direction][0], y + move[direction][1]};
        }

        public int[] location() {
            return new int[]{x, y};
        }

        public void moveBack() {
            int backDir = (direction + 2) % 4;
            x = x + move[backDir][0];
            y = y + move[backDir][1];
        }

        public void moveForward() {
            x = x + move[direction][0];
            y = y + move[direction][1];
        }

        public void changeDirection() {
            direction = (direction + 3) % 4; // 반시계 방향으로 90도 회전
        }
    }
}
