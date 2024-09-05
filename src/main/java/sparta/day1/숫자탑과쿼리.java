package sparta.day1;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/28127
public class 숫자탑과쿼리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <Q ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(d<=a){
                bw.write(1 +" " + d);
            }


        }
    }
}
