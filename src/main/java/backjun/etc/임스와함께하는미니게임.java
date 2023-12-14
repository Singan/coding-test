package backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int count = Integer.parseInt(str[0]);
        int game = switch(str[1]){
            case "Y" -> 1;
            case "F" -> 2;
            case "O" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + str[1]);
        };
        HashMap<String,String> hashMap = new HashMap();
        for (int i = 0; i < count; i++) {
            String name = br.readLine();
            hashMap.put(name,name);
        }

        System.out.println(hashMap.size()/game);
    }
}
