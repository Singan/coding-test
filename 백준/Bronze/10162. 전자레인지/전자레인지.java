
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int button[] = new int[3];
        int T = Integer.parseInt(br.readLine());

        // 300 , 60 , 10
        button[0] = T / 300;
        int temp = T % 300;

        button[1] = temp / 60;
        temp = temp % 60;

        button[2] = temp / 10;
        temp = temp % 10;

        System.out.println(temp == 0 ? button[0] + " " + button[1] + " " + button[2] : -1);

    }
}
