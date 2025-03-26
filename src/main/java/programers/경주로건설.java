package programers;

public class 경주로건설 {


    int board[][];
    int dp[][];

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board) {

        this.board = board;
        dp = new int[board.length][board[0].length];


        bfs(0,0,1);


        int answer = 0;
        return answer;
    }


    public int bfs(int x , int y,int direction) {
return 1;
    }
}
