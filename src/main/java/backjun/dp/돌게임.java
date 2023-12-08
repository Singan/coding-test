package backjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 돌게임 {
    public static void main(String[] args) {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            int N = Integer.parseInt(br.readLine());

            bw.write((N % 2 == 1) ? "SK" : "CY");
            bw.flush();
        } catch (Exception e) {

        }


    }
}
