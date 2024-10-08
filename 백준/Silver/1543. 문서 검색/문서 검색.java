import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String subStr = br.readLine();

        int count = 0;
        int index = str.indexOf(subStr, 0);


        while (index != -1) {
            index = str.indexOf(subStr, index + subStr.length());
            count++;
        }
        System.out.println(count);
    }
}
