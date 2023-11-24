package backjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//public class ACMCraft {
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int testCase = Integer.parseInt(br.readLine());
//        for (int i = 0; i < testCase; i++) {
//            String[] str = br.readLine().split(" ");
//            int n = Integer.parseInt(str[0]);
//            int k = Integer.parseInt(str[1]);
//            int[] build = new int[n];
//            boolean[][] takeTime = new boolean[n][n];
//            str = br.readLine().split(" ");
//            for (int j = 0; j < n; j++) {
//                build[j] = Integer.parseInt(str[j]);
//            }
//            for (int j = 0; j < k; j++) {
//                str = br.readLine().split(" ");
//                takeTime[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;
//                takeTime[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = true;
//            }
//
//            int want = Integer.parseInt(br.readLine());
//
//        }
//
//    }
//
//
//    public static void building(int[] build,boolean[][] takeTime,int want){
//        int start = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        while (!queue.isEmpty()){
//            int poll = queue.poll();
//            for (int i = 0; i < takeTime[poll].length; i++) {
//                if(takeTime[poll][i]){
//                    build[i]+= build[poll];
//                }
//            }
//        }
//    }
//}
