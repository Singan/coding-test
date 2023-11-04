package backjun.basic3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0;i<count;i++){
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int maxNamuge = maxNamuge(a,b);
            System.out.println(minGop(a,b,maxNamuge));
        }
    }
    public static int maxNamuge(int a , int b ){
        int min = a<b?a:b;
        int max = a>b?a:b;
        int namuge = max%min;
        if(namuge!=0){
            return maxNamuge(min,namuge);
        }
        return min;
    }
    public static int minGop(int a , int b ,int maxNamuge){
        return (a*b)/maxNamuge;
    }
}
