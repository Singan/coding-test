package programers;

public class 행렬테두리회전하기 {
    //,{3,3,6,6},{5,1,6,3}
    public static void main(String[] args) {
        new Solution().solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
    }

    //x1+1,y1
    //x2,y1-1
    //x1,y2+1
    //x2-1,y2
    //x2-x1 -1, y2-y1-1 에 잇는 애들은 안움직임
    private static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int square[][] = new int[rows][columns];
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    square[i - 1][j - 1] = ((i - 1) * columns + j);
                }
            }
            for (int i = 0; i < queries.length; i++) {
                int x1 = queries[i][0] - 1;
                int y1 = queries[i][1] - 1;
                int x2 = queries[i][2] - 1;
                int y2 = queries[i][3] - 1;

                int x1y1 = square[x1][y1];
                int min = x1y1;
                // 좌측 위아래
                for (int j = x1 ; j < x2; j++) {
                    int cur = square[j+1][y1];
                    square[j][y1] = cur;
                    if (min > cur) {
                        min = cur;
                    }
                }
                //아래쪽 좌로
                for (int j = y1; j <y2; j++) {
                    int cur = square[x2][j+1];
                    square[x2][j] = cur;
                    if (min > cur) {
                        min = cur;
                    }
                }
                // 우측 위아래
                for (int j = x2; j > x1; j--) {
                    int cur = square[j - 1][y2];
                    square[j][y2] = cur;
                    if (min > cur) {
                        min = cur;
                    }
                }
                // 위쪽 우로
                for (int j = y2; j > y1; j--) {
                    int cur = square[x1][j - 1];
                    square[x1][j] = cur;
                    if (min > cur) {
                        min = cur;
                    }
                }


                square[x1][y1 + 1] = x1y1;
                answer[i] = min;
            }
            return answer;

        }
    }
}
