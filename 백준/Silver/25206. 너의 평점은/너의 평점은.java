
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> map = Map.of(
                "A+", 4.5F,
                "A0", 4.0F,
                "B+", 3.5F,
                "B0", 3.0F,
                "C+", 2.5F,
                "C0", 2.0F,
                "D+", 1.5F,
                "D0", 1.0F,
                "F", 0.0F
        );

        float result = 0;
        float gr = 0;

        for (int i = 0; i < 20; i++) {
            String[] str = br.readLine().split(" ");
            if (str[2].equals("P"))
                continue;
            float grade = Float.parseFloat(str[1]);
            result += grade;
            gr += (grade * map.get(str[2]));
        }

        System.out.println(gr / result);

    }
}
