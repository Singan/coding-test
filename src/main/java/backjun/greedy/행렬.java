package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 행렬 {

    //1080번
    static Scanner sc = new Scanner(System.in);

    static int[][] a;
    static int[][] b;
    static int row;
    static int column;

    public static void main(String[] args) throws Exception {

        row = sc.nextInt();
        column = sc.nextInt();
        a = new int[row][column];
        b = new int[row][column];
        sc.nextLine();
        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                a[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                b[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }


        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (a[i][j] != b[i][j]) {
                    if (reverse(i, j))
                        result++;
                }
            }
        }
        if (Arrays.deepEquals(a, b)) {
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }

    static boolean reverse(int rowStart, int columnStart) {
        if (row < rowStart + 3 || column < columnStart + 3)
            return false;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
        return true;
    }
}
