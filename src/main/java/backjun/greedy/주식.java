package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println(test(br));
        }
    }

//    public static long test(BufferedReader br) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        long sum = 0;
//        int[] arr = new int[n];
//        int maxDay = 0;
//        int maxPrice = 0;
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//            if (maxPrice <= arr[i]) {
//                maxPrice = arr[i];
//                maxDay = i;
//            }
//        }
//        int i = 0;
//        int count = 0;
//        long result = 0;
//        while (maxDay > 0 && i <= maxDay) {
//            if (maxDay == i) {
//                result += ((long) count * (long) arr[i]) - sum;
//                i++;
//                maxPrice = 0;
//                count = 0;
//                sum = 0;
//                for (int j = i; j < n; j++) {
//                    if (maxPrice <= arr[j]) {
//                        maxPrice = arr[j];
//                        maxDay = j;
//                    }
//                }
//                continue;
//            }
//            if (i == arr.length)
//                break;
//            sum += arr[i];
//            count++;
//            i++;
//        }
//        return result;
//    }

    public static long test(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long sum = 0;
        int[] arr = new int[n];
        int maxPrice = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long result = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (maxPrice >= arr[i]) {
               result += maxPrice - arr[i] ;
            }else{
                maxPrice = arr[i];
            }
        }
        return result;
    }
}
