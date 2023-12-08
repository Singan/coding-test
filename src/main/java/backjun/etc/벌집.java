package backjun.etc;

import java.util.Scanner;

public class 벌집 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 1;
        int max = 1;
        while(true){
            if(n<=max)
                break;
            max+=count*6;
            count++;
        }
        System.out.println(count);
    }
}
