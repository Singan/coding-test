package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 덩치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] peoples = new int[count][3];
        for (int i = 0; i < count; i++) {
            String[] str = br.readLine().split(" ");
            int weight = Integer.parseInt(str[0]);
            int cm = Integer.parseInt(str[1]);
            peoples[i][0] = weight;
            peoples[i][1] = cm;
            peoples[i][2] = 1;
        }

        for (int i = 0; i < peoples.length; i++) {
            int []p = peoples[i];
            int pWeight = p[0];
            int pCm = p[1];
            for (int j = 0; j < peoples.length; j++) {
                if(i==j)
                    continue;
                if(pWeight < peoples[j][0] && pCm<peoples[j][1]){
                    p[2]+=1;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] p:peoples) {
            stringBuilder.append(p[2] +" ");
        }
        System.out.println(stringBuilder.toString());

    }
}
