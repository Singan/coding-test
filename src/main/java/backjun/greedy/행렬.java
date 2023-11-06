package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 행렬 {

    //1080번
    static Scanner sc = new Scanner(System.in);

    static int[][] a;
    static int[][] b;
    static int row = sc.nextInt();
    static int column = sc.nextInt();

    public static void main(String[] args) throws Exception {


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
        System.out.println(result < 1 ? -1 : result);
    }

    static boolean reverse(int row, int column) {
        if (a.length < row + 3 && a[0].length < column + 3)
            return false;
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
        return true;
    }
}
//3 42
//011001011111111100101000111111001010010111
//111111011001011001001011000111011110111011
//100101110101010111110100001001100110111110
//011001010110000110010000111001100111000110
//010010001100100111100010101000101101010100
//101111100111000010111000110011001111100011