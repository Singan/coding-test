
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        List<Integer> lisList = new ArrayList<>();

        for (int number : arr) {
            int position = Collections.binarySearch(lisList, number);

            if (position < 0) position = -(position + 1);

            if(position >= lisList.size()){
                lisList.add(number);
            }else{
                lisList.set(position , number);
            }
        }
        System.out.println(lisList.size());
    }
}
